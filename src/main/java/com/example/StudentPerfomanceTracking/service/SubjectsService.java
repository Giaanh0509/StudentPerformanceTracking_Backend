package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.http.ResponseEntity;

public interface SubjectsService {
    ResponseEntity<?> saveSubject(SubjectDTO subjectDTO);
}
