package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "objectives")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(length = 255)
    private String name;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "indicator_id", referencedColumnName = "id")
    private Indicator indicator;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private Set <Student> students;

    double start_value;

    double objective_value;

    public Objective() {
    }

    public Objective(Date startDate, Date endDate, Indicator indicator, double start_value, double objective_value) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.indicator = indicator;
        this.start_value = start_value;
        this.objective_value = objective_value;
    }
}
