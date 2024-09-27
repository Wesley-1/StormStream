package com.wtench.repo;

import com.wtench.StormCloud.domain.type.AbstractDomainEntity;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.domain.ChatMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ChatRepository extends StormCrudRepository<ChatMessage, String> {
}
