package com.wtench.controller;

import com.wtench.StormCloud.controllers.DomainEntityController;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.domain.ChatMessage;
import com.wtench.repo.ChatRepository;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
public class ChatController implements DomainEntityController<ChatMessage, ChatRepository> {

    private final DomainEntityService<ChatMessage, ChatRepository> service;

    public ChatController(DomainEntityService<ChatMessage, ChatRepository> service) {
        this.service = service;
    }

    @Override
    @GetMapping(path="/chat-messages")
    public Page<ChatMessage> list(Pageable pageable) {
        return null;
    }
}
