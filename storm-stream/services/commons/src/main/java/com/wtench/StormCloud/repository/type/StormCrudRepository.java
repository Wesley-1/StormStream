package com.wtench.StormCloud.repository.type;

import com.wtench.StormCloud.domain.AbstractDomainEntity;
import com.wtench.StormCloud.repository.StormRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StormCrudRepository<T extends AbstractDomainEntity, A> extends
        StormRepository,
        CrudRepository<T, A>,
        PagingAndSortingRepository<T, A>
{ }
