package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectTeacherDTO;
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
    public List<SubjectTeacherDTO> getAllSubjects() {
        return subjectsService.getAllSubjects();
    }

    @GetMapping("/userId={userId}")
    public List<SubjectDTO> getSubjectByUserId(@PathVariable int userId) {
        return subjectsService.findSubjectByUserId(userId);
    }

    @GetMapping("/subjectId={subjectId}")
    public SubjectDTO getSubjectById(@PathVariable int subjectId) {
        return subjectsService.findSubjectById(subjectId);
    }

    @GetMapping("/delete/{subjectId}")
    public String deleteGroup(@PathVariable int subjectId) {
        subjectsService.deleteSubjectById(subjectId);
        System.out.println(subjectId);
        return null;
    }

    @PutMapping("/update/{subjectId}")
    public Subject updateSubject(@RequestBody SubjectDTO subjectDTO) {
        System.out.println(subjectDTO.getId());
        System.out.println(subjectDTO.getName());
        System.out.println(subjectDTO.getDescription());
        return subjectsService.updateSubject(subjectDTO);
    }
}
