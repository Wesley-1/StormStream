package com.wtench.StormCloud.services;

import com.wtench.StormCloud.domain.DomainEntity;

public interface StormService<T extends DomainEntity> {

    void publish(T entity);

}
