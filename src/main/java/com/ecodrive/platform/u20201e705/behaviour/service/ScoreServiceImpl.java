package com.ecodrive.platform.behaviour.service;


import com.ecodrive.platform.behaviour.domain.model.entity.Score;
import com.ecodrive.platform.behaviour.domain.persistence.ScoreRepository;
import com.ecodrive.platform.behaviour.domain.service.ScoreService;
import com.ecodrive.platform.shared.exception.ResourceNotFoundException;
import com.ecodrive.platform.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ScoreServiceImpl implements ScoreService {

    private static final String ENTITY = "Score";

    private final ScoreRepository scoreRepository;

    private final Validator validator;

    public ScoreServiceImpl(ScoreRepository scoreRepository, Validator validator) {
        this.scoreRepository = scoreRepository;
        this.validator = validator;
    }

    @Override
    public List<Score> getAll() {
        return scoreRepository.findAll();
    }

    @Override
    public Page<Score> getAll(Pageable pageable) {
        return scoreRepository.findAll(pageable);
    }

    @Override
    public Score getById(Long scoreId) {
        return scoreRepository.findById(scoreId).
                orElseThrow(() -> new ResourceNotFoundException(ENTITY,scoreId));
    }

    @Override
    public List<Score> getByDriverId(Long driverId) {
        return scoreRepository.findByDriverId(driverId);
    }

    @Override
    public Score create(Score score) {
        Set<ConstraintViolation<Score>> violations = validator.validate(score);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return scoreRepository.save(score);
    }
}
