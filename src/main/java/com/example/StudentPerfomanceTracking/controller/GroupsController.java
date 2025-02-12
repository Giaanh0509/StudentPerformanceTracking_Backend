package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.dto.SubjectDTO;
import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController {
    @Autowired
    GroupsService groupsService;

    @PostMapping("/new")
    public Group createNewGroup(@RequestBody GroupDTO groupDTO) {
        return groupsService.saveGroup(groupDTO);
    }

    @GetMapping("/userId={userId}")
    public List<GroupDTO> getSubjectByUserId(@PathVariable int userId) {
        return groupsService.findGroupByUserId(userId);
    }

    @GetMapping("/delete/{groupId}")
    public String deleteGroup(@PathVariable int groupId) {
        groupsService.deleteGroupById(groupId);
        return "Group với ID " + groupId + " đã được xóa.";
    }
}
