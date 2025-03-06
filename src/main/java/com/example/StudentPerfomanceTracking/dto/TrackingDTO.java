package com.example.StudentPerfomanceTracking.dto;

public class TrackingDTO {
    private int id;

    private String name;

    private String createDate;

    private int objectiveId;

    public TrackingDTO(int id, String name, String createDate, int objectiveId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.objectiveId = objectiveId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getObjectiveId() {
        return objectiveId;
    }

    public void setObjectiveId(int objectiveId) {
        this.objectiveId = objectiveId;
    }
}
