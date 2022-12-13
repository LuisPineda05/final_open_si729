package com.ecodrive.platform.behaviour.resource;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateScoreResource {

    @NotNull
    private Long driverId;

    @NotNull
    private Float value;
}
