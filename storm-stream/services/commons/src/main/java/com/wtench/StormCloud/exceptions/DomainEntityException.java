package com.wtench.StormCloud.exceptions;

import com.wtench.StormCloud.domain.DomainEntity;
import lombok.Getter;

@Getter
public class DomainEntityException extends RuntimeException{

    private final DomainEntity entity;

    public DomainEntityException(DomainEntity entity) {
        this.entity = entity;
    }

    public DomainEntityException(String message, DomainEntity entity) {
        super(message);
        this.entity  = entity;
    }

    public DomainEntityException(Throwable cause, DomainEntity entity) {
        super(cause);
        this.entity  = entity;
    }

    public DomainEntityException(String message, Throwable cause, DomainEntity entity) {
        super(message, cause);
        this.entity  = entity;
    }

    public DomainEntityException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace, DomainEntity entity) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.entity  = entity;
    }
}
