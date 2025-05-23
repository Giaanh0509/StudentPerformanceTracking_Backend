package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface GroupsRepository extends JpaRepository<Group, Integer> {
    @Query("SELECT g FROM Group g WHERE g.user.id = :userId ORDER BY g.id DESC")
    List<Group> findGroupByUserId(@Param("userId") int userId);

    Group findGroupById(int userId);

    void deleteById(int id);
}
