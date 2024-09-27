package com.wtench.StormCloud.controllers;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import com.wtench.StormCloud.services.DomainEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DomainEntityController<T extends DomainEntity, B extends StormRepository> {

   DomainEntityService<T, B> getService();

   Page<T> list(Pageable pageable);

}
