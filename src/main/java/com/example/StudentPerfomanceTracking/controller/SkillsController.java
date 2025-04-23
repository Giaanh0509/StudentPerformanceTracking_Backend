package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.SkillDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Skill;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SkillsService;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillsController {
    @Autowired
    SkillsService skillsService;

    @PostMapping("/new")
    public ResponseEntity<SkillDTO> createNewSkill(@RequestBody SkillDTO skillDTO) {
        return skillsService.saveSkill(skillDTO);
    }

    @GetMapping("/id={id}")
    public SkillDTO getSkillById(@PathVariable("id") int id){
        return skillsService.getSkillById(id);
    }

    @GetMapping("/subjectId={subjectId}")
    public List<SkillDTO> getSkillsBySubjectId(@PathVariable("subjectId") int subjectId){
        return skillsService.getSkillsBySubjectId(subjectId);
    }

    @PutMapping("/update/id={id}")
    public SkillDTO updateSkillById(@PathVariable("id") int id, @RequestBody SkillDTO skillDTO) {
        return skillsService.updateSkillById(id, skillDTO);
    }

    @GetMapping("/delete/id={id}")
    public void deleteSkill(@PathVariable("id") int id) {
        skillsService.deleteSkillById(id);
        return;
    }
 }
