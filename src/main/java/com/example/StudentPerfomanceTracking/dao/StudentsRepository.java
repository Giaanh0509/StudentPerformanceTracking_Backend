package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface StudentsRepository extends JpaRepository<Student, Integer> {
    Student findStudentById(int id);
    Student findStudentByUserId(int userId);
    @Query("SELECT s FROM Student s WHERE s.user.id = :userId")
    Student findOneStudentByUserId(@Param("userId") int userId);
}
