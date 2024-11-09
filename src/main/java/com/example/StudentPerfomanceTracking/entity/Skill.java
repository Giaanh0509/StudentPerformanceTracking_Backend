package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "parent_skill_id")
    private Skill parentSkillId;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String formula;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private Set<Indicator> indicators;

    public Skill() {

    }

    public Skill(String name, Subject subject, Skill parentSkillId, String description, String formula) {
        this.name = name;
        this.subject = subject;
        this.parentSkillId = parentSkillId;
        this.description = description;
        this.formula = formula;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Skill getParentSkill() {
        return parentSkillId;
    }

    public void setParentSkill(Skill parentSkill) {
        this.parentSkillId = parentSkill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }
}
