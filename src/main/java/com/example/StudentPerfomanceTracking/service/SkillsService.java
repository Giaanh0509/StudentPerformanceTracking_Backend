package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;

public interface SkillsService {
    Skill saveSkill(SkillDTO skillDTO);
}
