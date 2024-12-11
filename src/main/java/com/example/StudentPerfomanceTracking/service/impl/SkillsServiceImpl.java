package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.SkillsRepository;
import com.example.StudentPerfomanceTracking.dao.SubjectsRepository;
import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<SkillDTO> saveSkill(SkillDTO skillDTO) {
        Subject subject = subjectsRepository.findSubjectById(skillDTO.getSubjectId());

        if(skillDTO.getParentSkillId() == 0) {
            Skill skill = new Skill(skillDTO.getName(), subject, skillDTO.getDescription(), skillDTO.getFormula(), skillDTO.getChildren(), skillDTO.getCreateDate());
            skillsRepository.save(skill);
            skillDTO.setId(skill.getId());
        } else {
            Skill parentSkill = skillsRepository.findSkillById(skillDTO.getParentSkillId());
            Skill skill = new Skill(skillDTO.getName(), subject, parentSkill,skillDTO.getDescription(), skillDTO.getFormula(), skillDTO.getChildren(), skillDTO.getCreateDate());
            skillsRepository.save(skill);
            skillDTO.setId(skill.getId());
        }

        return ResponseEntity.ok(skillDTO);
    }
}
