package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @Column
    private int userId;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private Set<ObjectiveDetail> objectiveDetails;

    public Objective() {
    }

    public Objective(String name) {
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Set<ObjectiveDetail> getObjectiveDetails() {
        return objectiveDetails;
    }

    public void setObjectiveDetails(Set<ObjectiveDetail> objectiveDetails) {
        this.objectiveDetails = objectiveDetails;
    }
}
