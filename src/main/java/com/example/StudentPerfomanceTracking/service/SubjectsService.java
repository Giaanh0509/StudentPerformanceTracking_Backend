package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectsService {
    Subject saveSubject(SubjectDTO subjectDTO);

    Subject findSubjectById(int id);

    List<Subject> getAll();
}
