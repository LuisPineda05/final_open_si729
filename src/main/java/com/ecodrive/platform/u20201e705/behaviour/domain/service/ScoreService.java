package com.ecodrive.platform.behaviour.domain.service;

import com.ecodrive.platform.behaviour.domain.model.entity.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;



public interface ScoreService {
    List<Score> getAll();
    Page<Score> getAll(Pageable pageable);
    Score getById(Long scoreId);
    List<Score> getByDriverId(Long driverId);
    Score create(Score score);
}
