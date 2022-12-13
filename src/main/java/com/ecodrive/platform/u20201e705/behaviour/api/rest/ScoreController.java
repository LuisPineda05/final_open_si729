package com.ecodrive.platform.behaviour.api.rest;

import com.ecodrive.platform.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.behaviour.mapping.ScoreMapper;
import com.ecodrive.platform.behaviour.resource.CreateScoreResource;
import com.ecodrive.platform.behaviour.resource.ScoreResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/drivers/{driverId}/scores", produces = "application/json")
@Tag(name = "Scores", description = "Create, read, update and delete scores")
public class ScoreController {
    private final ScoreService scoreService;

    private final ScoreMapper mapper;

    public ScoreController(ScoreService scoreService, ScoreMapper mapper) {
        this.scoreService = scoreService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ScoreResource> getAllScores(Pageable pageable) {
        return mapper.modelListPage(scoreService.getAll(),pageable);
    }

    @GetMapping
    public Page<ScoreResource> getAllScoresByDriverId(@PathVariable Long driverId,
                                                           Pageable pageable) {
        return mapper.modelListPage(scoreService.getByDriverId(driverId), pageable);
    }



    @PostMapping
    public ScoreResource createPlace(@RequestBody CreateScoreResource resource) {
        return mapper.toResource(scoreService.create(mapper.toModel(resource)));
    }
}
