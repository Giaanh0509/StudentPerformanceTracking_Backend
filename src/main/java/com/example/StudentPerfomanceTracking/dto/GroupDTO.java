package com.example.StudentPerfomanceTracking.dto;

public class GroupDTO {
    private int id;

    private String name;

    private String description;

    private String createDate;

    private int userId;

    public GroupDTO() {
    }

    public GroupDTO(int id, String name, String description, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
    }

    public GroupDTO(int id, String name, String description, String createDate, int userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.userId = userId;
    }

    public GroupDTO(String name, int userId) {
        this.name = name;
        this.userId = userId;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
