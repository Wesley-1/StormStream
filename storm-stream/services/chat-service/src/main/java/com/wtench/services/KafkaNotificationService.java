package com.wtench.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.services.impl.KafkaService;
import com.wtench.config.KafkaConfigProps;
import com.wtench.domain.Notification;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaNotificationService extends KafkaService<KafkaConfigProps, Notification> {
    public KafkaNotificationService(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate, KafkaConfigProps kafkaConfigProps) {
        super(objectMapper, kafkaTemplate, kafkaConfigProps);
    }
}
