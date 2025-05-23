package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Indicator;
import com.example.StudentPerfomanceTracking.entity.ObjectiveDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface ObjectivesDetailsRepository extends JpaRepository<ObjectiveDetail, Integer> {
    @Query("SELECT o.indicator FROM ObjectiveDetail o WHERE o.objective.id = :objectiveId")
    List<Indicator> findIndicatorsByObjectiveId(@Param("objectiveId") Integer objectiveId);
}
