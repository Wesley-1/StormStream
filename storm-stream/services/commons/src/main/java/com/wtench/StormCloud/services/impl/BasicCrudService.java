package com.wtench.StormCloud.services.impl;

import com.wtench.StormCloud.repository.StormRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public abstract class BasicCrudService<A, T extends StormRepository> implements DomainEntityService<A, T> {

    private final T repository;

    public BasicCrudService(T repository) {
        this.repository = repository;
    }
}
