package com.wtench.services;

import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.impl.BasicCrudService;
import com.wtench.domain.ChatMessage;
import com.wtench.repo.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService extends BasicCrudService<ChatMessage, String> {

    public ChatService(ChatRepository repository) {
        super(repository);
    }
}
