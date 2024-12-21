package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.StudentsGroupsRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsRepository;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.StudentGroup;
import com.example.StudentPerfomanceTracking.service.GroupsStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupsStudentsServiceImpl implements GroupsStudentsService {

    @Autowired
    private StudentsGroupsRepository studentsGroupsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    public List<StudentDTO> findStudentByGroupId(int groupId) {
        List<StudentGroup> studentGroupList = studentsGroupsRepository.findByGroupId(groupId);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentGroup studentGroup: studentGroupList) {
            Student student = studentsRepository.findStudentById(studentGroup.getStudent().getId());
            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getUser().getId(), groupId);

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}
