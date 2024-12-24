package com.example.StudentPerfomanceTracking.dto;

public class UserLoginDTO {
    int id;
    String username;
    int roleId;

    public UserLoginDTO(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserLoginDTO(int id, String username, int roleId) {
        this.id = id;
        this.username = username;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
