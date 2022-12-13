package com.ecodrive.platform.behaviour.domain.persistence;

import com.ecodrive.platform.behaviour.domain.model.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Long> {

    List<Score> findByDriverId(Long driverId);
}
