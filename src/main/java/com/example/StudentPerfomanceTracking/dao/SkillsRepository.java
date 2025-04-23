package com.example.StudentPerfomanceTracking.dao;

import com.example.StudentPerfomanceTracking.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface SkillsRepository extends JpaRepository<Skill, Integer> {
    Skill findSkillById(int id);

    List<Skill> findSkillBySubjectId(int subjectId);

    @Query("SELECT s FROM Skill s WHERE s.subject.id = :subjectId AND s.parentSkillId IS NULL")
    List<Skill> findBySubjectIdAndParentSkillIsNull(@Param("subjectId") int subjectId);

    @Modifying
    @Query("DELETE FROM Skill s WHERE s.id = :id")
    void deleteSkillById(int id);
}
