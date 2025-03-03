package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trackings")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column(name = "tracking_date")
    private Date trackingDate;

    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    public Tracking(String name, Date trackingDate, Objective objective) {
        this.name = name;
        this.trackingDate = trackingDate;
        this.objective = objective;
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

    public Date getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(Date trackingDate) {
        this.trackingDate = trackingDate;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
