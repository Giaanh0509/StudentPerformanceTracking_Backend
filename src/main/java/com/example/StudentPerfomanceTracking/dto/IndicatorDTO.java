package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IndicatorDTO {
    private int id;

    private String name;

    @JsonProperty("scale_min")
    private double scaleMin;

    @JsonProperty("scale_max")
    private double scaleMax;

    @JsonProperty("evaluation_type")
    private String evaluationType;

    private int skillId;

    private String skillName;

    public IndicatorDTO() {
    }

    public IndicatorDTO(int id, String name, double scaleMin, double scaleMax, String evaluationType, int skillId) {
        this.id = id;
        this.name = name;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
        this.evaluationType = evaluationType;
        this.skillId = skillId;
    }

    public IndicatorDTO(int id, String name, double scaleMin, double scaleMax, String evaluationType, int skillId, String skillName) {
        this.id = id;
        this.name = name;
        this.scaleMin = scaleMin;
        this.scaleMax = scaleMax;
        this.evaluationType = evaluationType;
        this.skillId = skillId;
        this.skillName = skillName;
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

    public String getEvaluationType() {
        return evaluationType;
    }

    public void setEvaluationType(String evaluationType) {
        this.evaluationType = evaluationType;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
}
