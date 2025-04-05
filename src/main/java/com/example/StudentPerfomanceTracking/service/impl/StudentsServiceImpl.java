package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.*;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    StudentsObjectivesRepository studentsObjectivesRepository;


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
    public StudentDTO findStudentByUserId(int userId) {
        Student student = studentsRepository.findStudentByUserId(userId);
        if(student != null) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getDateOfBirth(),
                    student.getEmail(),
                    student.getUser().getId()
            );
            return studentDTO;
        } else {
            return null;
        }
    }

    @Override
    public StudentDTO getStudentByUserId(int userId) {
        Student student = studentsRepository.findOneStudentByUserId(userId);
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getName(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getUser().getId()
        );
        return studentDTO;
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

    @Override
    public List<StudentDTO> findStudentByObjectiveId(int objectiveId) {
        List<Student> studentList = studentsObjectivesRepository.findStudentsByObjectiveId(objectiveId);
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
    public Student updateStudent(StudentDTO studentDTO) {
        Student existStudent = studentsRepository.findStudentById(studentDTO.getId());
        existStudent.setName(studentDTO.getName());
        existStudent.setDateOfBirth(studentDTO.getDateOfBirth());

        studentsRepository.save(existStudent);
        return existStudent;
    }
}
