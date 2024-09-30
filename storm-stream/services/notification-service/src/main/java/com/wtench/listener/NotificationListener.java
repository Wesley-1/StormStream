package com.wtench.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.listeners.DomainEntityListener;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.StormCloud.services.impl.KafkaService;
import com.wtench.domain.Notification;
import com.wtench.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Profile("production")
@Component
public class NotificationListener extends DomainEntityListener<Notification, NotificationRepository> {

    private final DomainEntityService<Notification, NotificationRepository> entityService;

    public NotificationListener(ObjectMapper objectMapper,
                        DomainEntityService<Notification, NotificationRepository> entityService) {
        super(objectMapper, entityService);
        this.entityService = entityService;

    }

    @KafkaListener(topics = "notification.published")
    public String listens(final String in) {
        try {
            final Map<String, Object> payload = readJsonAsMap(in);
            final Notification message = entityFromPayload(payload);
            entityService.save(message);
            System.out.println("Got it: " + message.getMessage());
        } catch(RuntimeException ignored) {}
        return in;
    }

    @Override
    public Notification entityFromPayload(Map<String, Object> payload) {
        Notification notification = Notification.builder()
                .message((String) payload.get("message"))
                .service((String) payload.get("service"))
                .timestamp(LocalDateTime.parse((String) payload.get("timestamp")))
                .build();
        notification.setId((Long) payload.get("id"));
        return notification;
    }
}
