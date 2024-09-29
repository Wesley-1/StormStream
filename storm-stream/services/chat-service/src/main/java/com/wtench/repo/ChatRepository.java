package com.wtench.repo;

import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.domain.ChatMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends StormCrudRepository<ChatMessage, String> {
}
