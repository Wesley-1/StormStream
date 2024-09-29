package com.wtench.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.listeners.DomainEntityListener;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.StormCloud.services.impl.KafkaService;
import com.wtench.domain.ChatMessage;
import com.wtench.domain.Notification;
import com.wtench.repo.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Profile("production")
@Component
public class ChatListener extends DomainEntityListener<ChatMessage, ChatRepository> {

    private final DomainEntityService<ChatMessage, ChatRepository> entityService;
    private final KafkaService<Notification> notificationKafkaService;

    public ChatListener(ObjectMapper objectMapper,
                        DomainEntityService<ChatMessage, ChatRepository> entityService,
                        KafkaService<Notification> notificationKafkaService) {
        super(objectMapper, entityService);
        this.entityService = entityService;
        this.notificationKafkaService = notificationKafkaService;

    }

    @KafkaListener(topics = "message.published")
    public String listens(final String in) {

        try {
            final Map<String, Object> payload = readJsonAsMap(in);

            final ChatMessage message = entityFromPayload(payload);
            final ChatMessage savedMessage = entityService.save(message);

            final String output = String.format(
                    "Message '%s' [%s] persisted!",
                    savedMessage.getMessage(),
                    savedMessage.getId()
            );

            notificationKafkaService.publish(Notification.builder()
                    .service("chat_service")
                    .timestamp(LocalDateTime.now())
                    .message(savedMessage.getMessage())
                    .build());

        } catch(RuntimeException ignored) {}

        return in;
    }

    @Override
    public ChatMessage entityFromPayload(Map<String, Object> payload) {
        ChatMessage message = ChatMessage.builder().message((String) payload.get("message")).build();
        message.setId((Long) payload.get("id"));
        return message;
    }
}
