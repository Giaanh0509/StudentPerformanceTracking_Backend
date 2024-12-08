package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.SubjectsRepository;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public Subject saveSubject(SubjectDTO subjectDTO) {
        System.out.println(subjectDTO.getCreateDate());
        Subject subject = new Subject(subjectDTO.getName(), subjectDTO.getCreateDate());
        subjectsRepository.save(subject);
        return subject;
    }

    @Override
    public Subject findSubjectById(int id) {
        return subjectsRepository.findSubjectById(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectsRepository.findAll();
    }
}
