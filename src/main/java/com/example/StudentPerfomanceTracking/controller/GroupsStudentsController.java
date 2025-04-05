package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.StudentGroupDTO;
import com.example.StudentPerfomanceTracking.entity.StudentGroup;
import com.example.StudentPerfomanceTracking.service.GroupsStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/studentId={studentId}")
    public List<GroupDTO> getGroupByStudentId(@PathVariable int studentId) {
        return groupsStudentsService.findGroupByStudentId(studentId);
    }

    @GetMapping("/studentId={studentId}/groupId={groupId}")
    public StudentGroup.Status getGroupByStudentId(@PathVariable int studentId, @PathVariable int groupId) {
        return groupsStudentsService.findStatus(studentId, groupId);
    }

    @PostMapping("/updateStatus")
    public StudentGroup updateStatus(@RequestBody StudentGroupDTO studentGroupDTO) {
        return groupsStudentsService.updateStatus(studentGroupDTO);
    }

    @GetMapping("/joinRequest/groupId={groupId}")
    public List<StudentDTO> updateStatus(@PathVariable int groupId) {
        return groupsStudentsService.joinRequest(groupId);
    }

    @GetMapping("/acceptRequest/studentId={studentId}/groupId={groupId}")
    public void updateStatus(@PathVariable int studentId, @PathVariable int groupId) {
        groupsStudentsService.acceptRequest(studentId, groupId);
    }
}
