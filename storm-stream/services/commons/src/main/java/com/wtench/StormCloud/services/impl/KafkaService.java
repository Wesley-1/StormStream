package com.wtench.StormCloud.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.config.KafkaConfig;
import com.wtench.StormCloud.domain.AbstractDomainEntity;
import com.wtench.StormCloud.exceptions.DomainEntityException;
import com.wtench.StormCloud.services.StormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class KafkaService<T extends AbstractDomainEntity> implements StormService<T> {
    private final ObjectMapper objectMapper;

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final String topic;

    public KafkaService(
            ObjectMapper objectMapper,
            KafkaTemplate<String, String> kafkaTemplate,
            String topic) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    @Override
    public void publish(T entity) {
        try {
            final String payload = objectMapper.writeValueAsString(entity);
            kafkaTemplate.send(topic, payload);
        } catch (final JsonProcessingException ex) {
            throw new DomainEntityException("Error when publishing entity: " + entity.getClass().getSimpleName(), ex, entity);
        }
    }
}
