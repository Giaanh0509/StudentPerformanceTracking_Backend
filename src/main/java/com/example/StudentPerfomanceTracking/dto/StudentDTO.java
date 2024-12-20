package com.example.StudentPerfomanceTracking.dto;

public class StudentDTO {
    private int id;
    private String name;

    private int userId;

    private int groupId;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public StudentDTO(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
