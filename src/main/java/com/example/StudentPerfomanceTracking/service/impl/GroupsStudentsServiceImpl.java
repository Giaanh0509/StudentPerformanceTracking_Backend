package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.GroupsRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsGroupsRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsRepository;
import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.StudentGroupDTO;
import com.example.StudentPerfomanceTracking.entity.Group;
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

    @Autowired
    private GroupsRepository groupsRepository;

    @Override
    public List<StudentDTO> findStudentByGroupId(int groupId) {
        List<StudentGroup> studentGroupList = studentsGroupsRepository.findByGroupId(groupId);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentGroup studentGroup: studentGroupList) {
            Student student = studentsRepository.findStudentById(studentGroup.getStudent().getId());
            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getDateOfBirth(), student.getEmail(), student.getUser().getId(), groupId);

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public List<GroupDTO> findGroupByStudentId(int studentId) {
        List<StudentGroup> studentGroupList = studentsGroupsRepository.findByStudentId(studentId);
        List<GroupDTO> groupDTOList = new ArrayList<>();

        for(StudentGroup studentGroup: studentGroupList) {
            System.out.println(studentGroup.getGroup().getId());
            Group group = groupsRepository.findGroupById(studentGroup.getGroup().getId());
            GroupDTO groupDTO = new GroupDTO(group.getId(), group.getName(), group.getDescription(), group.getCreateDate(), group.getUser().getId(), studentGroup.getStatus());
            groupDTOList.add(groupDTO);
        }

        return groupDTOList;
    }

    @Override
    public StudentGroup.Status findStatus(int studentId, int groupId) {
        StudentGroup studentGroupList = studentsGroupsRepository.findByStudentIdAndGroupId(studentId, groupId);
        if(studentGroupList == null) {
            return null;
        } else return studentGroupList.getStatus();
    }

    @Override
    public StudentGroup updateStatus(StudentGroupDTO studentGroupDTO) {
        Student student = studentsRepository.findStudentById(studentGroupDTO.getStudentId());
        Group group = groupsRepository.findGroupById(studentGroupDTO.getGroupId());
        StudentGroup studentGroup = new StudentGroup(student, group, studentGroupDTO.getStatus());
        studentsGroupsRepository.save(studentGroup);
        return studentGroup;
    }

    @Override
    public List<StudentDTO> joinRequest(int groupId) {
        List<StudentGroup> studentGroupList = studentsGroupsRepository.findByGroupId(groupId);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for(StudentGroup studentGroup: studentGroupList) {
            Student student = studentsRepository.findStudentById(studentGroup.getStudent().getId());
            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getName(), student.getDateOfBirth(), student.getEmail(), student.getUser().getId(), groupId);

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}
