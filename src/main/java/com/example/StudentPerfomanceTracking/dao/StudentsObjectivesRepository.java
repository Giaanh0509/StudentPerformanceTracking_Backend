package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.StudentObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface StudentsObjectivesRepository extends JpaRepository<StudentObjective, Integer> {

    @Query("SELECT sg.group FROM StudentObjective sg WHERE sg.objective.id = :objectiveId")
    Group findGroupByObjectiveId(@Param("objectiveId") int objectiveId);

    @Query("SELECT so.student FROM StudentObjective so WHERE so.objective.id = :objectiveId")
    List<Student> findStudentsByObjectiveId(@Param("objectiveId") int objectiveId);
}
