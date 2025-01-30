package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @PostMapping("/new")
    public Subject createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectsService.saveSubject(subjectDTO);
    }

    @GetMapping("/all")
    public List<SubjectDTO> getAllSubjects() {
        return subjectsService.getAllSubjects();
    }

    @GetMapping("/userId={userId}")
    public List<SubjectDTO> getSubjectByUserId(@PathVariable int userId) {
        return subjectsService.findSubjectByUserId(userId);
    }

    @GetMapping("/subjectId={subjectId}")
}
