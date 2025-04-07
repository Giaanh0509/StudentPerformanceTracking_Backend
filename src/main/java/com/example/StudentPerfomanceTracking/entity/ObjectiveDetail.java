package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "objective_details")
public class ObjectiveDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "indicator_id", referencedColumnName = "id")
    private Indicator indicator;

    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    double start_value;

    double objective_value;

    public ObjectiveDetail() {
    }

    public ObjectiveDetail(Objective objective, Indicator indicator, double start_value, double objective_value) {
        this.objective = objective;
        this.indicator = indicator;
        this.start_value = start_value;
        this.objective_value = objective_value;
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

    public Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator indicator) {
        this.indicator = indicator;
    }

    public double getStart_value() {
        return start_value;
    }

    public void setStart_value(double start_value) {
        this.start_value = start_value;
    }

    public double getObjective_value() {
        return objective_value;
    }

    public void setObjective_value(double objective_value) {
        this.objective_value = objective_value;
    }
}
