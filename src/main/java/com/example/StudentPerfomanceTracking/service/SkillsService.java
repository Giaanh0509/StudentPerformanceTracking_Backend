package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import org.springframework.http.ResponseEntity;

public interface SkillsService {
    ResponseEntity<SkillDTO> saveSkill(SkillDTO skillDTO);
}
