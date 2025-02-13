package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "groups_st")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(name = "create_date")
    private String createDate;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentGroup> studentGroups;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<StudentObjective> studentObjectives;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Group() {
    }

    public Group(String name, Set<StudentGroup> studentGroups) {
        this.name = name;
        this.studentGroups = studentGroups;
    }

    public Group(String name, String description, User user) {
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public Group(String name, String description, String createDate, User user) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.user = user;
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

    public Set<StudentObjective> getStudentObjectives() {
        return studentObjectives;
    }

    public void setStudentObjectives(Set<StudentObjective> studentObjectives) {
        this.studentObjectives = studentObjectives;
    }
}
