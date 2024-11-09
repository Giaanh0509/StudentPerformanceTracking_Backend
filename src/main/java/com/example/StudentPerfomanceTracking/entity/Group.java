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

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private Set<StudentGroup> studentGroups;

    public Group() {
    }

    public Group(String name, Set<StudentGroup> studentGroups) {
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
}
