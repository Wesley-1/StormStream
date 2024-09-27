package com.wtench.repo;

import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.domain.ChatMessage;
import jakarta.persistence.MappedSuperclass;
import org.jetbrains.annotations.NotNull;

@MappedSuperclass
public interface ChatRepository extends StormCrudRepository<ChatMessage, String> {

    @NotNull
    @Override
    <S extends ChatMessage> S save(S entity);

    @NotNull
    @Override
    Iterable<ChatMessage> findAll();
}
