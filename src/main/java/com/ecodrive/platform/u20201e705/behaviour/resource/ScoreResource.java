package com.ecodrive.platform.behaviour.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ScoreResource {
    private Long id;
    private Long driverId;
    private Float value;
}
