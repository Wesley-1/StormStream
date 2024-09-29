package com.wtench.StormCloud.exceptions;

import com.wtench.StormCloud.domain.AbstractDomainEntity;
import lombok.Getter;

@Getter
public class DomainEntityException extends RuntimeException{

    private final AbstractDomainEntity<?> entity;

    public DomainEntityException(AbstractDomainEntity entity) {
        this.entity = entity;
    }

    public DomainEntityException(String message, AbstractDomainEntity entity) {
        super(message);
        this.entity  = entity;
    }

    public DomainEntityException(Throwable cause, AbstractDomainEntity entity) {
        super(cause);
        this.entity  = entity;
    }

    public DomainEntityException(String message, Throwable cause, AbstractDomainEntity entity) {
        super(message, cause);
        this.entity  = entity;
    }

    public DomainEntityException(String message, Throwable cause, boolean enableSuppression,
                                boolean writableStackTrace, Object entity) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.entity = (AbstractDomainEntity<?>) entity;
    }
}
