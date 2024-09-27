package com.wtench.StormCloud.repository.type;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

@MappedSuperclass
public interface StormCrudRepository<T extends DomainEntity, A> extends
        StormRepository,
        CrudRepository<T, A>,
        PagingAndSortingRepository<T, A>
{ }
