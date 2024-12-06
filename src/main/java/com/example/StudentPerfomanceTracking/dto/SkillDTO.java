package com.example.StudentPerfomanceTracking.dto;

public class SkillDTO {
    private int id;

    private String name;

    private String formula;

    private String description;

    private int subjectId;

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
}
