package com.ecodrive.platform.u20201e705.behaviour.resource;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateScoreResource {


    @NotNull
    private Float value;
}
