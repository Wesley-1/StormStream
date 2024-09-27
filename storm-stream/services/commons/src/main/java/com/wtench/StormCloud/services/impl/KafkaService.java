package com.wtench.StormCloud.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.config.KafkaConfig;
import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.exceptions.DomainEntityException;
import com.wtench.StormCloud.services.StormService;
import org.springframework.kafka.core.KafkaTemplate;

public abstract class KafkaService<A extends KafkaConfig, T extends DomainEntity> implements StormService<T> {
    private final ObjectMapper objectMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final A kafkaConfigProps;

    public KafkaService(
            ObjectMapper objectMapper,
            KafkaTemplate<String, String> kafkaTemplate,
            A kafkaConfigProps) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    @Override
    public void publish(T entity) {
        try {
            final String payload = objectMapper.writeValueAsString(entity);
            kafkaTemplate.send(kafkaConfigProps.getTopic(), payload);
        } catch (final JsonProcessingException ex) {
            throw new DomainEntityException("Error when publishing entity: " + entity.getClass().getSimpleName(), ex, entity);
        }
    }
}
