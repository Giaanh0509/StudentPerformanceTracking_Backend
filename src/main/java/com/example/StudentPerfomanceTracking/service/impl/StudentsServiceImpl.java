package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.StudentsRepository;
import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.StudentGroup;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.entity.User;
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

    @Override
    public Student saveStudent(StudentDTO studentDTO) {
        User user = usersRepository.findById(studentDTO.getUserId());
        Student student = new Student(studentDTO.getName(), user);
        StudentGroup studentGroup = new StudentGroup();
        studentsRepository.save(student);
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
                    student.getUser().getId()
            );

            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}
