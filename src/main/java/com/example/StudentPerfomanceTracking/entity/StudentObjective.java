package com.example.StudentPerfomanceTracking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students_objectives")
public class StudentObjective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "objective_id", referencedColumnName = "id")
    private Objective objective;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    public StudentObjective() {
    }

    public StudentObjective(Student student, Objective objective) {
        this.student = student;
        this.objective = objective;
    }

    public StudentObjective(Student student, Objective objective, Group group) {
        this.student = student;
        this.objective = objective;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }
}
