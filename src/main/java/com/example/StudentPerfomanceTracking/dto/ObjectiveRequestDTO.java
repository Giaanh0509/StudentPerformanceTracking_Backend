package com.example.StudentPerfomanceTracking.dto;

import java.util.List;

public class ObjectiveRequestDTO {
    private int group_id;
    private String objectiveName;
    private List<ObjectiveDTO> objectives;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public List<ObjectiveDTO> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<ObjectiveDTO> objectives) {
        this.objectives = objectives;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }
}

