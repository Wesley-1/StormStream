package com.wtench.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.services.impl.KafkaService;
import com.wtench.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationService extends KafkaService<Notification> {
    public KafkaNotificationService(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        super(objectMapper, kafkaTemplate, "notification.published");
    }
}
