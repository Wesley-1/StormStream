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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
public class ChatController implements DomainEntityController<MessageDTO, ChatMessage, ChatRepository> {

    private final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @Override
    @GetMapping(path="/get/chat-messages")
    public Page<MessageDTO> list(Pageable pageable) {
        return ResponseEntity.ok(getService().getRepository().findAll(pageable).map(this::mapEntity)).getBody();
    }

    @PostMapping(value = "/post/chat-messages")
    public ChatMessage post(ChatMessage message) {
        return message;
    }

    @Override
    public MessageDTO mapEntity(ChatMessage entity) {
        return MessageDTO.builder().message(entity.getMessage()).id(entity.getId()).build();
    }


}
