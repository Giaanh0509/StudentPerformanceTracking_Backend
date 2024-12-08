package com.example.StudentPerfomanceTracking.dto;

import java.util.Date;

public class SubjectDTO {
    private int id;

    private String name;

    private String createDate;

    public SubjectDTO() {
    }

    public SubjectDTO(String name) {
        this.name = name;
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
}
