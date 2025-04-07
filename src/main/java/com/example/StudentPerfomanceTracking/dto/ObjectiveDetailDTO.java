package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectiveDetailDTO {

    @JsonProperty("start_value")
    private double startValue;

    @JsonProperty("objective_value")
    private double objectiveValue;

    @JsonProperty("indicator_id")
    private int indicatorId;

    public ObjectiveDetailDTO() {
    }

    public double getStartValue() {
        return startValue;
    }

    public void setStartValue(double startValue) {
        this.startValue = startValue;
    }

    public double getObjectiveValue() {
        return objectiveValue;
    }

    public void setObjectiveValue(double objectiveValue) {
        this.objectiveValue = objectiveValue;
    }

    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(int indicatorId) {
        this.indicatorId = indicatorId;
    }
}
