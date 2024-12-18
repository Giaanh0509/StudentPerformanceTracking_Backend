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
    SubjectsService subjectsService;

    @PostMapping("/new")
    public Subject createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectsService.saveSubject(subjectDTO);
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable int id) {
        return subjectsService.findSubjectById(id);
    }
}
