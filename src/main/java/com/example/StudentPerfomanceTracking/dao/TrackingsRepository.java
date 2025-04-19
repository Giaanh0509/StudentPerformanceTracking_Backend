package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Objective;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.entity.Tracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface TrackingsRepository extends JpaRepository<Tracking, Integer> {
    Tracking findTrackingById(int id);

    @Query("SELECT t FROM Tracking t WHERE t.objective.id = :objectiveId ORDER BY t.id DESC")
    List<Tracking> findByObjectiveId(int objectiveId);

    @Query("SELECT t.objective FROM Tracking t WHERE t.id = :trackingId")
    Objective findObjectiveByTrackingId(@Param("trackingId") int trackingId);
}
