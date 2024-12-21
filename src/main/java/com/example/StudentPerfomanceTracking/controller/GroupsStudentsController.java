package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.service.GroupsStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groupsStudents")
public class GroupsStudentsController {
    @Autowired
    private GroupsStudentsService groupsStudentsService;

    @GetMapping("/groupId={groupId}")
    public List<StudentDTO> getStudentByGroupId(@PathVariable int groupId) {
        return groupsStudentsService.findStudentByGroupId(groupId);
    }
}
