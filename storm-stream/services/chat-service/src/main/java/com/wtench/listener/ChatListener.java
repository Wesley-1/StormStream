package com.wtench.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.listeners.DomainEntityListener;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.domain.ChatMessage;
import com.wtench.repo.ChatRepository;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Profile("production")
@Component
public class ChatListener extends DomainEntityListener<ChatMessage, ChatRepository> {

    private final Logger logger = LoggerFactory.getLogger("message.published");
    private final DomainEntityService<ChatMessage, ChatRepository> entityService;

    public ChatListener(ObjectMapper objectMapper,
                        DomainEntityService<ChatMessage, ChatRepository> entityService) {
        super(objectMapper, entityService);
        this.entityService = entityService;

    }

    @KafkaListener(topics = "message.published")
    public String listens(final String in) {

        logger.info("Received Message: {}", in);
        try {
            final Map<String, Object> payload = readJsonAsMap(in);

            final ChatMessage message = entityFromPayload(payload);
            final ChatMessage savedMessage = entityService.save(message);

            final String output = String.format(
                    "Message '%s' [%s] persisted!",
                    savedMessage.getMessage(),
                    savedMessage.getId()
            );

            logger.info(output);

        } catch(RuntimeException ex) {
            logger.error("Invalid message received: {}", in);
        }

        return in;
    }

    @Override
    public ChatMessage entityFromPayload(Map<String, Object> payload) {
        return ChatMessage.builder()
                .message((String) payload.get("message"))
                .id((Long) payload.get("id"))
                .build();
    }
}
