package com.example.StudentPerfomanceTracking.dto;

public class ScoreDTO {
    private String skillName;

    private String indicator;

    private double value;

    private double scaleMax;

    public ScoreDTO() {
    }

    public ScoreDTO(String skillName, String indicator, double value, double scaleMax) {
        this.skillName = skillName;
        this.indicator = indicator;
        this.value = value;
        this.scaleMax = scaleMax;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getScaleMax() {
        return scaleMax;
    }

    public void setScaleMax(double scaleMax) {
        this.scaleMax = scaleMax;
    }
}
