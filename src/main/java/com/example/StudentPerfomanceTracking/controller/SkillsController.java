package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SkillsService;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @PostMapping("/new")
    public ResponseEntity<SkillDTO> createNewSkill(@RequestBody SkillDTO skillDTO) {
        return skillsService.saveSkill(skillDTO);
    }
}
