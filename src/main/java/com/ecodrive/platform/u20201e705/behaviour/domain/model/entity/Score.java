package com.ecodrive.platform.u20201e705.behaviour.domain.model.entity;

import com.ecodrive.platform.u20201e705.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "scores")
public class Score extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long driverId;

    @NotNull
    private Float value;

}
