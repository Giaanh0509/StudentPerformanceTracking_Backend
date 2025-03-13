package com.example.StudentPerfomanceTracking.dto;

public class StudentTrackingUpdateDTO {
    private int id;

    private double trackingValue;

    public StudentTrackingUpdateDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTrackingValue() {
        return trackingValue;
    }

    public void setTrackingValue(double trackingValue) {
        this.trackingValue = trackingValue;
    }
}
