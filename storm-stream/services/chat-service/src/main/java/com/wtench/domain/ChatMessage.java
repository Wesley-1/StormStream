package com.wtench.domain;

import com.wtench.StormCloud.domain.AbstractDomainEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatMessage extends AbstractDomainEntity<Long> {
    String message;
}
