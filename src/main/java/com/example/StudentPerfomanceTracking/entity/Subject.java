package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "description")
    private String description;

    @Column(name = "uses")
    private Integer uses;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<Skill> skills;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<Objective> objectives;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Subject() {

    }

    public Subject(String name, String createDate) {
        this.name = name;
        this.createDate = createDate;
    }

    public Subject(String name, String createDate, User user) {
        this.name = name;
        this.createDate = createDate;
        this.user = user;
    }

    public Subject(String name, String createDate, String description, User user) {
        this.name = name;
        this.createDate = createDate;
        this.description = description;
        this.user = user;
    }

    public Subject(String name, String createDate, String description, Integer uses, User user) {
        this.name = name;
        this.createDate = createDate;
        this.description = description;
        this.uses = uses;
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

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
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

    public int getUses() {
        return uses;
    }

    public void setUses(int uses) {
        this.uses = uses;
    }

    public void setUses(Integer uses) {
        this.uses = uses;
    }
}
