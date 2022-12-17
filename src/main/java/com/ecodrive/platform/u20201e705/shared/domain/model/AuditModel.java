package com.ecodrive.platform.u20201e705.shared.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"registeredAt"}, allowGetters = true)
public class AuditModel implements Serializable {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registered_at", nullable = false, updatable = false)
    @CreatedDate
    private Date registeredAt;

    @PrePersist
    void createdAt() {
        this.registeredAt = new Date();
    }

}
