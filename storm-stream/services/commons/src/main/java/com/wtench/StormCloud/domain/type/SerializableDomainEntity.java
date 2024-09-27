package com.wtench.StormCloud.domain.type;

import com.wtench.StormCloud.domain.DomainEntity;

public interface SerializableDomainEntity<A> extends DomainEntity {

    String serialize();

    A deserialize(String json);

    A clone(A entity);

}
