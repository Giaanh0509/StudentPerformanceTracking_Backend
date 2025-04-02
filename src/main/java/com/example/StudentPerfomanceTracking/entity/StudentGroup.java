package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "students_groups")
public class StudentGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "request_date")
    private String requestDate;

    public StudentGroup() {
    }

    public StudentGroup(Student student, Group group) {
        this.student = student;
        this.group = group;
    }

    public StudentGroup(Student student, Group group, Status status) {
        this.student = student;
        this.group = group;
        this.status = status;
    }

    public StudentGroup(Student student, Group group, Status status, String requestDate) {
        this.student = student;
        this.group = group;
        this.status = status;
        this.requestDate = requestDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
}
