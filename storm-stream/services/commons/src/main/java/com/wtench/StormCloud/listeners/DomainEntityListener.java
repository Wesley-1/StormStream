package com.wtench.StormCloud.listeners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wtench.StormCloud.services.DomainEntityService;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public abstract class DomainEntityListener<T, A> {
    private final ObjectMapper objectMapper;

    private final DomainEntityService<T, A> entityService;

    public DomainEntityListener(ObjectMapper objectMapper, DomainEntityService<T, A> entityService) {
        this.objectMapper = objectMapper;
        this.entityService = entityService;
    }

    public abstract String listens(String in);

    public abstract T entityFromPayload(Map<String, Object> payload);

    public Map<String, Object> readJsonAsMap(final String json) {
        try{
            final TypeReference<HashMap<String,Object>> typeRef = new TypeReference<>() {};
            return objectMapper.readValue(json, typeRef);
        } catch(JsonProcessingException ex) {
            throw new RuntimeException("Error reading json.");
        }
    }

}
