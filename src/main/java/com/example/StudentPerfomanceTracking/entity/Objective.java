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
    private String createDate;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private Set<ObjectiveDetail> objectiveDetails;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private Set<StudentObjective> studentObjectives;

    public Objective() {
    }

    public Objective(String name) {
        this.name = name;
    }

    public Objective(String name, User user, Subject subject) {
        this.name = name;
        this.user = user;
        this.subject = subject;
    }

    public Objective(String name, String createDate, User user, Subject subject) {
        this.name = name;
        this.createDate = createDate;
        this.user = user;
        this.subject = subject;
    }

    public Objective(String name, String createDate, String startDate, String endDate, User user, Subject subject) {
        this.name = name;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.subject = subject;
    }

    public Objective(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
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

    public Set<ObjectiveDetail> getObjectiveDetails() {
        return objectiveDetails;
    }

    public void setObjectiveDetails(Set<ObjectiveDetail> objectiveDetails) {
        this.objectiveDetails = objectiveDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
