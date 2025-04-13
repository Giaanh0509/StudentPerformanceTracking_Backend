package com.example.StudentPerfomanceTracking.dto;

import java.util.Date;

public class SubjectDTO {
    private int id;

    private String name;

    private String createDate;

    private String description;

    private int uses;

    private int userId;

    public SubjectDTO() {
    }

    public SubjectDTO(String name) {
        this.name = name;
    }

    public SubjectDTO(int id, String name, String createDate, int uses, int userId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.uses = uses;
        this.userId = userId;
    }

    public SubjectDTO(int id, String name, String createDate, int userId) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
