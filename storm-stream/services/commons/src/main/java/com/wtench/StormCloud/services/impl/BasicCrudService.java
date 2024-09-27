package com.wtench.StormCloud.services.impl;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
public class BasicCrudService<T extends DomainEntity, A> implements DomainEntityService<T, StormCrudRepository<T, A>> {

    private final StormCrudRepository<T, A> repository;

    public BasicCrudService(StormCrudRepository<T, A> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Page<T> list(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
