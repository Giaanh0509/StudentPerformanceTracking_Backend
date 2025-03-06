package com.example.StudentPerfomanceTracking.dto;

public class TrackingDetailsDTO {
    private int studentId;

    private double trackingValue;

    public TrackingDetailsDTO(int studentId, double trackingValue) {
        this.studentId = studentId;
        this.trackingValue = trackingValue;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public double getTrackingValue() {
        return trackingValue;
    }

    public void setTrackingValue(double trackingValue) {
        this.trackingValue = trackingValue;
    }
}
