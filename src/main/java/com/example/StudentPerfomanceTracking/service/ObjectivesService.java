package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;
import com.example.StudentPerfomanceTracking.dto.ObjectiveDetailDTO;

import java.util.List;

public interface ObjectivesService {
    void saveObjective(int groupId, String createDate, int subjectId, int userId, String objectiveName, List<ObjectiveDetailDTO> objectiveDetailDTOList);
    List<ObjectiveDTO> findObjectivesByUserId(int userId);
    void deleteObjective(int objectiveId);
}
