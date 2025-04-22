package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SkillsService {
    ResponseEntity<SkillDTO> saveSkill(SkillDTO skillDTO);

    SkillDTO getSkillById(int id);

    SkillDTO updateSkillById(int id, SkillDTO skillDTO);

    List<SkillDTO> getSkillsBySubjectId(int subjectId);
}
