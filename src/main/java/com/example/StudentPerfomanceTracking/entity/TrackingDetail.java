package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tracking_details")
public class TrackingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tracking_value")
    private double trackingValue;

    @Column(name = "tracking_date")
    private String trackingDate;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "tracking_id", referencedColumnName = "id")
    private Tracking tracking;

    @ManyToOne
    @JoinColumn(name = "indicator_id", referencedColumnName = "id")
    private Indicator indicator;

    public TrackingDetail(double trackingValue, String trackingDate, Student student, Tracking tracking, Indicator indicator) {
        this.trackingValue = trackingValue;
        this.trackingDate = trackingDate;
        this.student = student;
        this.tracking = tracking;
        this.indicator = indicator;
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

    public String getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(String trackingDate) {
        this.trackingDate = trackingDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Tracking getTracking() {
        return tracking;
    }

    public void setTracking(Tracking tracking) {
        this.tracking = tracking;
    }

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }
}
