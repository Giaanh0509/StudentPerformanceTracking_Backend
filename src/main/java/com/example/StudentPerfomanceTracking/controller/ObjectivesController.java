package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;
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
        String objectiveName = requestDTO.getObjectiveName();
        List<ObjectiveDTO> objectives = requestDTO.getObjectives();

        objectivesService.saveObjective(groupId, objectiveName, objectives);
    }

    @GetMapping("/userId={userId}")
    public void getObjectiveByUserId(@PathVariable int userId) {

    }
}
