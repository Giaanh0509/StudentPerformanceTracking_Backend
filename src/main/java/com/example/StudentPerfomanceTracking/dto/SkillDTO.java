package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillDTO {
    private int id;

    private String name;

    private double formula;

    private String description;

    private boolean childrenSkill;

    private String createDate;

    private int subjectId;

    @JsonProperty("parentSkillId")
    private int parentSkillId;

    public SkillDTO() {
    }

    public SkillDTO(String name, double formula, String description, int subjectId) {
        this.name = name;
        this.formula = formula;
        this.description = description;
        this.subjectId = subjectId;
    }

    public SkillDTO(int id, String name, double formula, String description, boolean childrenSkill, String createDate, int subjectId) {
        this.id = id;
        this.name = name;
        this.formula = formula;
        this.description = description;
        this.childrenSkill = childrenSkill;
        this.createDate = createDate;
        this.subjectId = subjectId;
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

    public double getFormula() {
        return formula;
    }

    public void setFormula(double formula) {
        this.formula = formula;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getParentSkillId() {
        return parentSkillId;
    }

    public void setParentSkillId(int parentSkillId) {
        this.parentSkillId = parentSkillId;
    }

    public boolean isChildrenSkill() {
        return childrenSkill;
    }

    public void setChildrenSkill(boolean childrenSkill) {
        this.childrenSkill = childrenSkill;
    }
}
