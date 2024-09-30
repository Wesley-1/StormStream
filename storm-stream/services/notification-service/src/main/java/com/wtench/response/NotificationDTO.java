package com.wtench.response;

import com.wtench.StormCloud.response.ResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements ResponseEntity {
    String message;
    LocalDateTime timestamp;
    String service;
    long id;
}
