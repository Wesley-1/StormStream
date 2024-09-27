package com.wtench.services;

import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.StormCloud.services.impl.BasicCrudService;
import com.wtench.domain.ChatMessage;
import com.wtench.repo.ChatRepository;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
@Service
@MappedSuperclass
public class ChatService implements DomainEntityService<ChatMessage, ChatRepository> {

    private final ChatRepository repository;
    public ChatService(ChatRepository repository) {
        this.repository = repository;
    }

    @Override
    public ChatMessage save(ChatMessage entity) {
        return getRepository().save(entity);
    }

    @Override
    public Page<ChatMessage> list(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
}
