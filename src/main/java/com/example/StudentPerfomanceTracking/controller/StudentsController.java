package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Subject;
import com.example.StudentPerfomanceTracking.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    StudentsService studentsService;

    @PostMapping("/new")
    public Student createNewStudent(@RequestBody StudentDTO studentDTO) {
        return studentsService.saveStudent(studentDTO);
    }

    @PostMapping("/newList")
    public void createNewListStudent(@RequestBody List<StudentDTO> studentDTOList) {
        studentsService.saveNewListStudent(studentDTOList);
        return;
    }

    @GetMapping("/userId={userId}")
    public StudentDTO getStudentsByUserId(@PathVariable int userId) {
        return studentsService.findStudentByUserId(userId);
    }

    @GetMapping("/objectiveId={objectiveId}")
    public List<StudentDTO> getStudentByObjectiveId(@PathVariable int objectiveId) {
        return studentsService.findStudentByObjectiveId(objectiveId);
    }

    @PutMapping("/update/{studentId}")
    public Student updateSubject(@RequestBody StudentDTO studentDTO) {
        return studentsService.updateStudent(studentDTO);
    }
}
