package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.entity.Student;

import java.util.List;

public interface GroupsStudentsService {
    List<StudentDTO> findStudentByGroupId(int groupId);
}
