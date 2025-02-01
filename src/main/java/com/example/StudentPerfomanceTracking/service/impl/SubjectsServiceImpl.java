package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.SubjectsRepository;
import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.dto.IndicatorDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Indicator;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    SubjectsRepository subjectsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Subject saveSubject(SubjectDTO subjectDTO) {
        User user = usersRepository.findById(subjectDTO.getUserId());
        Subject subject = new Subject(subjectDTO.getName(), subjectDTO.getCreateDate(), user);
        subjectsRepository.save(subject);
        return subject;
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjectList = subjectsRepository.findAll();
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        for (Subject subject: subjectList) {
            SubjectDTO subjectDTO = new SubjectDTO(
                    subject.getId(),
                    subject.getName(),
                    subject.getCreateDate(),
                    subject.getUser().getId()
            );

            subjectDTOList.add(subjectDTO);
        }

        return subjectDTOList;
    }

    @Override
    public SubjectDTO findSubjectById(int id) {
        Subject subject = subjectsRepository.findSubjectById(id);
        SubjectDTO subjectDTO = new SubjectDTO(subject.getId(),
                subject.getName(),
                subject.getCreateDate(),
                subject.getUser().getId());
        return subjectDTO;
    }

    @Override
    public List<SubjectDTO> findSubjectByUserId(int userId) {
        List<Subject> subjectList = subjectsRepository.findSubjectByUserId(userId);
        List<SubjectDTO> subjectDtoList = new ArrayList<>();
        for (Subject subject : subjectList) {
            SubjectDTO subjectDTO = new SubjectDTO(
                    subject.getId(),
                    subject.getName(),
                    subject.getCreateDate(),
                    subject.getUser().getId()
                    );

            subjectDtoList.add(subjectDTO);
        }
        return subjectDtoList;
    }

    @Override
    public List<Subject> getAll() {
        return subjectsRepository.findAll();
    }
}
