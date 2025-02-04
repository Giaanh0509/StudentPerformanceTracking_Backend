package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;

import java.util.List;

public interface ObjectivesService {
    void saveObjective(int groupId, String objectiveName, List<ObjectiveDTO> objectiveDTOList);
}
