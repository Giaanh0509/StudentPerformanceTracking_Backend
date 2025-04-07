package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.entity.Objective;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface ObjectivesRepository extends JpaRepository<Objective, Integer> {
    List<Objective> findObjectiveByUserId(int userId);
    @Modifying
    @Query("DELETE FROM Objective o WHERE o.id = :id")
    void deleteObjectiveById(int id);
    Objective findObjectiveById(int objectiveId);

    @Query("SELECT sg.user FROM Objective sg WHERE sg.id = :objectiveId")
    User findUserByObjectiveId(@Param("objectiveId") int objectiveId);
}
