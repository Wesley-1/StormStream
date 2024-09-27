package com.wtench.StormCloud.services.impl;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import com.wtench.StormCloud.repository.type.StormCrudRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import com.wtench.StormCloud.services.StormService;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Getter
public abstract class BasicCrudService<A, T extends StormRepository> implements DomainEntityService<A, T> {

    private final T repository;

    public BasicCrudService(T repository) {
        this.repository = repository;
    }
}
