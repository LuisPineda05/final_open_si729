package com.ecodrive.platform.behaviour.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("scoresMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public ScoreMapper destinationMapper() { return new ScoreMapper();}

}
