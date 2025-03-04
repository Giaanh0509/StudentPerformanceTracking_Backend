package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trackings")
public class Tracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @Column(name = "create_date")
    private String create_date;

    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    @OneToMany(mappedBy = "tracking", cascade = CascadeType.ALL)
    private Set<TrackingDetail> trackingDetails;

    public Tracking(String name, String create_date, Objective objective) {
        this.name = name;
        this.create_date = create_date;
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

    public String getTrackingDate() {
        return create_date;
    }

    public void setTrackingDate(String create_date) {
        this.create_date = create_date;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
