package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.GroupsRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsGroupsRepository;
import com.example.StudentPerfomanceTracking.dao.StudentsRepository;
import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    StudentsGroupsRepository studentsGroupsRepository;


    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        User user = usersRepository.findById(studentDTO.getUserId());
        Student student = new Student(studentDTO.getName(), studentDTO.getDateOfBirth(), studentDTO.getEmail(), user);
        Group group = groupsRepository.findGroupById(studentDTO.getGroupId());
        StudentGroup studentGroup = new StudentGroup(student, group);
        studentsRepository.save(student);
        studentsGroupsRepository.save(studentGroup);
        return student;
    }

    @Override
    public List<StudentDTO> findStudentByUserId(int userId) {
        List<Student> studentList = studentsRepository.findStudentByUserId(userId);
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : studentList) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getDateOfBirth(),
                    student.getEmail(),
                    student.getUser().getId()
            );

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }

    @Override
    public Student saveNewListStudent(List<StudentDTO> studentDTOList) {
        for(StudentDTO studentDTO: studentDTOList) {
            User user = usersRepository.findById(studentDTO.getUserId());
            Student student = new Student(studentDTO.getName(), studentDTO.getDateOfBirth(), studentDTO.getEmail(), user);
            Group group = groupsRepository.findGroupById(studentDTO.getGroupId());
            StudentGroup studentGroup = new StudentGroup(student, group);
            studentsRepository.save(student);
            studentsGroupsRepository.save(studentGroup);
        }
        return null;
    }
}
