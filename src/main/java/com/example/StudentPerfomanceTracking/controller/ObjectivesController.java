package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;
import com.example.StudentPerfomanceTracking.dto.ObjectiveDetailDTO;
import com.example.StudentPerfomanceTracking.dto.ObjectiveRequestDTO;
import com.example.StudentPerfomanceTracking.service.ObjectivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objectives")
public class ObjectivesController {

    @Autowired
    ObjectivesService objectivesService;

    @PostMapping("/new")
    public void createNewObjective(@RequestBody ObjectiveRequestDTO requestDTO) {
        int groupId = requestDTO.getGroup_id();
        int subjectId = requestDTO.getSubject_id();
        int userId = requestDTO.getUser_id();
        String createDate = requestDTO.getCreateDate();
        String objectiveName = requestDTO.getObjectiveName();
        List<ObjectiveDetailDTO> objectives = requestDTO.getObjectives();

        objectivesService.saveObjective(groupId, createDate, subjectId, userId, objectiveName, objectives);
    }

    @GetMapping("/userId={userId}")
    public List<ObjectiveDTO> getObjectiveByUserId(@PathVariable int userId) {
       return objectivesService.findObjectivesByUserId(userId);
    }

    @GetMapping("/delete/objectiveId={objectiveId}")
    public String deleteSubject(@PathVariable int objectiveId) {
        objectivesService.deleteObjective(objectiveId);
        return null;
    }
}
