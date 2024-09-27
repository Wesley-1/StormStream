package com.wtench.domain;

import com.wtench.StormCloud.domain.DomainEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notification implements DomainEntity {
    private String message;
    private LocalDateTime timestamp;
    private String service;
}

