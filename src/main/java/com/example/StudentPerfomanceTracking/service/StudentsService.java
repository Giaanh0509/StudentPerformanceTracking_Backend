package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Student;

import java.util.List;

public interface StudentsService {
    Student saveStudent(StudentDTO studentDTO);
    List<StudentDTO> findStudentByUserId(int userId);
    StudentDTO getStudentByUserId(int userId);
    Student saveNewListStudent(List<StudentDTO> studentDTOList);
    List<StudentDTO> findStudentByObjectiveId(int objectiveId);
    Student updateStudent(StudentDTO studentDTO);
}
