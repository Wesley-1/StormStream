package com.wtench.domain;

import com.wtench.StormCloud.domain.DomainEntity;
import com.wtench.StormCloud.domain.type.SerializableDomainEntity;
import com.wtench.StormCloud.services.DomainEntityService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="chat-messages")
public class ChatMessage implements DomainEntity {
    @Id
    private Long id;

    String message;
}
