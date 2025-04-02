package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource
public interface StudentsGroupsRepository extends JpaRepository<StudentGroup, Integer> {
    List<StudentGroup> findByGroupId(int groupId);

    List<StudentGroup> findByStudentId(int studentId);

    StudentGroup findByStudentIdAndGroupId(int studentId, int groupId);

    @Query("SELECT sg.student FROM StudentGroup sg WHERE sg.group.id = :groupId")
    List<Student> findStudentId(@Param("groupId") int groupId);

    void deleteByGroupId(int groupId);
}
