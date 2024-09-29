package com.wtench.StormCloud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomainEntityService<T, A> {

    A getRepository();

    T save(T entity);

    Page<T> list(Pageable pageable);
}
