package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource (path = "subjects")
public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
    Subject findSubjectById(int id);

    @Query("SELECT s FROM Subject s WHERE s.user.id = :userId ORDER BY s.id DESC")
    List<Subject> findSubjectByUserId(int userId);
    List<Subject> findAll();
    @Modifying
    @Query("DELETE FROM Subject s WHERE s.id = :id")
    void deleteSubjectById(int id);
}
