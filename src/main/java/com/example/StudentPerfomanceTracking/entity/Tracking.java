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

    @Column(name = "tracking_date")
    private Date trackingDate;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    private Double trackingValue;
}
