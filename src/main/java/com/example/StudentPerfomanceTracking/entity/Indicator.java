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

    private Double scaleMin;

    private Double scaleMax;

    @OneToMany(mappedBy = "indicator")
    private Set<Objective> objectives;

    public Indicator() {
    }

    public Indicator(String name, Skill skill, String evaluationType, Double scaleMin, Double scaleMax, Set<Objective> objectives) {
        this.name = name;
        this.skill = skill;
        this.evaluationType = evaluationType;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
        this.objectives = objectives;
    }
}
