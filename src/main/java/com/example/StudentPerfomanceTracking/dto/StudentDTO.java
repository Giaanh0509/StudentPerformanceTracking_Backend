package com.example.StudentPerfomanceTracking.dto;

public class StudentDTO {
    private int id;

    private String name;

    private String dateOfBirth;

    private String email;

    private int userId;

    private int groupId;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public StudentDTO(int id, String name, int userId, int groupId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.groupId = groupId;
    }

    public StudentDTO(int id, String name, String dateOfBirth, String email, int userId, int groupId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.userId = userId;
        this.groupId = groupId;
    }

    public StudentDTO(int id, String name, String dateOfBirth, String email, int userId) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
