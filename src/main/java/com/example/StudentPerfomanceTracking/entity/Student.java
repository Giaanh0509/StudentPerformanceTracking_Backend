package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = " students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String dateOfBirth;

    @Column(length = 255)
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentObjective> studentObjectives;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<TrackingDetail> trackingDetails;

    public Student() {
    }

    public Student(String email, User user) {
        this.email = email;
        this.user = user;
    }

    public Student(String name, String dateOfBirth, String email, User user) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.user = user;
    }

    public Student(String name, Set<StudentGroup> studentGroups) {
        this.name = name;
        this.studentGroups = studentGroups;
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

    public Set<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    public void setStudentGroups(Set<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
