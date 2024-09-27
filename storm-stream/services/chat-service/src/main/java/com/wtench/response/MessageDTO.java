package com.wtench.response;

import com.wtench.StormCloud.response.ResponseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO implements ResponseEntity {
    String message;
    long id;
}
