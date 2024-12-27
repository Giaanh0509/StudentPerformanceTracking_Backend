package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectsService {
    Subject saveSubject(SubjectDTO subjectDTO);
    List<SubjectDTO> getAllSubjects();
    Subject findSubjectById(int id);
    List<SubjectDTO> findSubjectByUserId(int userId);
    List<Subject> getAll();
}
