package com.wtench.StormCloud.services;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomainEntityService<T extends DomainEntity, A extends StormRepository> {

    A getRepository();

    T save(T entity);

    Page<T> list(Pageable pageable);
}
