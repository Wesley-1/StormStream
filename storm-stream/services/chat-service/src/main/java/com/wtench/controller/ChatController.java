package com.wtench.controller;

import com.wtench.StormCloud.controllers.DomainEntityController;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.domain.ChatMessage;
import com.wtench.repo.ChatRepository;
import com.wtench.response.MessageDTO;
import com.wtench.services.ChatService;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@RestController
@RequestMapping("api/chat")
public class ChatController implements DomainEntityController<MessageDTO, ChatMessage, ChatRepository> {

    private final ChatService service;

    @Autowired
    public ChatController(ChatService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path="/allMessages")
    public Page<MessageDTO> list(Pageable pageable) {
        return getService().getRepository().findAll(pageable).map(this::mapEntity);
    }

    @PostMapping(value = "/addMessage")
    public ChatMessage post(ChatMessage message) {
        return message;
    }

    @Override
    public MessageDTO mapEntity(ChatMessage entity) {
        return MessageDTO.builder().message(entity.getMessage()).id(entity.getId()).build();
    }

}
