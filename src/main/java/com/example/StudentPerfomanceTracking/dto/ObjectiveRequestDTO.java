package com.example.StudentPerfomanceTracking.dto;

import java.util.List;

public class ObjectiveRequestDTO {
    private int group_id;
    private String objectiveName;
    private int subject_id;
    private int user_id;
    private String createDate;
    private List<ObjectiveDetailDTO> objectives;

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public List<ObjectiveDetailDTO> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<ObjectiveDetailDTO> objectives) {
        this.objectives = objectives;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}

