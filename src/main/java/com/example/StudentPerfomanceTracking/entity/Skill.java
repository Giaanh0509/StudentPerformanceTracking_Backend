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
    private double formula;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private Set<Indicator> indicators;

    @Column(name = "children_skill")
    private boolean childrenSkill;

    @Column(name = "create_date")
    private String createDate;

    public Skill() {

    }

    public Skill(String name, Subject subject, String description, double formula) {
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.formula = formula;
    }

    public Skill(String name, Subject subject, String description, double formula, boolean childrenSkill, String createDate) {
        this.name = name;
        this.subject = subject;
        this.description = description;
        this.formula = formula;
        this.childrenSkill = childrenSkill;
        this.createDate = createDate;
    }

    public Skill(String name, Subject subject, Skill parentSkillId, String description, double formula, boolean childrenSkill, String createDate) {
        this.name = name;
        this.subject = subject;
        this.parentSkillId = parentSkillId;
        this.description = description;
        this.formula = formula;
        this.childrenSkill = childrenSkill;
        this.createDate = createDate;
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

    public double getFormula() {
        return formula;
    }

    public void setFormula(double formula) {
        this.formula = formula;
    }

    public Skill getParentSkillId() {
        return parentSkillId;
    }

    public void setParentSkillId(Skill parentSkillId) {
        this.parentSkillId = parentSkillId;
    }

    public Set<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(Set<Indicator> indicators) {
        this.indicators = indicators;
    }

    public boolean isChildrenSkill() {
        return childrenSkill;
    }

    public void setChildrenSkill(boolean childrenSkill) {
        this.childrenSkill = childrenSkill;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
