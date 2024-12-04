package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000/")
@Controller
@RequestMapping("/subjects")
public class SubjectsController {

    @Autowired
    SubjectsService subjectsService;

    @PostMapping("/")
    public ResponseEntity<?> registerUser(@RequestBody SubjectDTO subjectDTO) {
        ResponseEntity<?> response = subjectsService.saveSubject(subjectDTO);
        return response;
    }

}
