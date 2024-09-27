package com.wtench.StormCloud.controllers;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import com.wtench.StormCloud.response.ResponseEntity;
import com.wtench.StormCloud.services.DomainEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomainEntityController<A extends ResponseEntity, T, B> {

   DomainEntityService<T, B> getService();

   Page<A> list(Pageable pageable);

   T post(T entity);

   A mapEntity(T entity);

}
