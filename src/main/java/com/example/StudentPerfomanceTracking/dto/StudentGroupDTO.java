package com.example.StudentPerfomanceTracking.dto;

import com.example.StudentPerfomanceTracking.entity.StudentGroup;

public class StudentGroupDTO {
    private int studentId;

    private int groupId;

    private StudentGroup.Status status;

    public StudentGroupDTO(int studentId, int groupId, StudentGroup.Status status) {
        this.studentId = studentId;
        this.groupId = groupId;
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public StudentGroup.Status getStatus() {
        return status;
    }

    public void setStatus(StudentGroup.Status status) {
        this.status = status;
    }
}
