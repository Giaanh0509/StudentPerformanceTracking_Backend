package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.StudentObjective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface StudentsObjectivesRepository extends JpaRepository<StudentObjective, Integer> {
}
