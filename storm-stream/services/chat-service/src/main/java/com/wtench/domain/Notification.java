package com.wtench.domain;

import com.wtench.StormCloud.domain.AbstractDomainEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notification extends AbstractDomainEntity<Long> {
    private String message;
    private LocalDateTime timestamp;
    private String service;
}

