package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "indicators")
public class Indicator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private Skill skill;

    @Column(length = 50)
    private String evaluationType;

    private double scaleMin;

    private double scaleMax;

    @OneToMany(mappedBy = "indicator")
    private Set<ObjectiveDetail> objectiveDetails;

    public Indicator() {
    }

    public Indicator(String name, Skill skill, String evaluationType, double scaleMin, double scaleMax) {
        this.name = name;
        this.skill = skill;
        this.evaluationType = evaluationType;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
    }

    public Indicator(String name, Skill skill, String evaluationType, double scaleMin, double scaleMax, Set<ObjectiveDetail> objectives) {
        this.name = name;
        this.skill = skill;
        this.evaluationType = evaluationType;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
        this.objectiveDetails = objectives;
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public double getScaleMin() {
        return scaleMin;
    }

    public void setScaleMin(double scaleMin) {
        this.scaleMin = scaleMin;
    }

    public double getScaleMax() {
        return scaleMax;
    }

    public void setScaleMax(double scaleMax) {
        this.scaleMax = scaleMax;
    }

    public Set<ObjectiveDetail> getObjectiveDetails() {
        return objectiveDetails;
    }

    public void setObjectiveDetails(Set<ObjectiveDetail> objectiveDetails) {
        this.objectiveDetails = objectiveDetails;
    }
}

