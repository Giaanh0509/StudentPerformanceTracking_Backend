package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.StudentGroupDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.StudentGroup;

import java.util.List;

public interface GroupsStudentsService {
    List<StudentDTO> findStudentByGroupId(int groupId);
    List<GroupDTO> findGroupByStudentId(int studentId);
    StudentGroup.Status findStatus(int studentId, int groupId);
    StudentGroup updateStatus(StudentGroupDTO studentGroupDTO);
    List<StudentDTO> joinRequest(int groupId);
    void acceptRequest(int studentId, int groupId);
}
