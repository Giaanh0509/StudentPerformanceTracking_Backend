package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.SkillsRepository;
import com.example.StudentPerfomanceTracking.dao.SubjectsRepository;
import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsServiceImpl implements SkillsService {

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public Skill saveSkill(SkillDTO skillDTO) {
        Subject subject = subjectsRepository.findSubjectById(skillDTO.getSubjectId());
        Skill skill = new Skill(skillDTO.getName(), subject, skillDTO.getDescription(), skillDTO.getFormula());
        skillsRepository.save(skill);
        return skill;
    }
}
