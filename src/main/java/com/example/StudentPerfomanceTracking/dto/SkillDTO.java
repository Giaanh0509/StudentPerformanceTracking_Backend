package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkillDTO {
    private int id;

    private String name;

    private String formula;

    private String description;

    private boolean children;

    private String createDate;

    private int subjectId;

    @JsonProperty("parentSkillId")
    private int parentSkillId;

    public SkillDTO() {
    }

    public SkillDTO(String name, String formula, String description, int subjectId) {
        this.name = name;
        this.formula = formula;
        this.description = description;
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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
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

    public boolean getChildren() {
        return children;
    }

    public void setChildren(boolean childrenSkill) {
        this.children = childrenSkill;
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
}
