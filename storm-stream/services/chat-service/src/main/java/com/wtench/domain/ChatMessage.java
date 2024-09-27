package com.wtench.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.wtench.StormCloud.domain.type.AbstractDomainEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatMessage extends AbstractDomainEntity<Long> {

    String message;
}
