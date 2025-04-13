package com.example.StudentPerfomanceTracking.dto;

public class SubjectTeacherDTO {
    private int id;

    private String name;

    private String createDate;

    private int uses;

    private String userName;

    public SubjectTeacherDTO(int id, String name, String createDate, int uses, String userName) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.uses = uses;
        this.userName = userName;
    }

    public SubjectTeacherDTO(String name, String createDate, String userName) {
        this.name = name;
        this.createDate = createDate;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public SubjectTeacherDTO(int uses) {
        this.uses = uses;
    }

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }
}
