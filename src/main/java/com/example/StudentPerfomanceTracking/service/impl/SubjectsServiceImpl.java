package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.SubjectsRepository;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public ResponseEntity<?> saveSubject(SubjectDTO subjectDTO) {
        Subject subject = new Subject(subjectDTO.getName());
        subjectsRepository.save(subject);
        return ResponseEntity.ok("Successful Create New Subject");
    }
}
