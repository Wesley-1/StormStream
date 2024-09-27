package com.wtench.StormCloud.domain.type;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
/*
@Table(name="...")
 */
public abstract class AbstractDomainEntity<T extends Serializable> {
    @Id
    private T id;
}
