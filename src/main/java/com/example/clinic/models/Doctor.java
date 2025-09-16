package com.example.clinic.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.time.LocalTime;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    // availableTime: time when doctor is available (ex: start of shift)
    @Column(name = "available_time", nullable = false)
    private LocalTime availableTime;

    public Doctor() {}

    public Doctor(String name, String specialization, LocalTime availableTime) {
        this.name = name;
        this.specialization = specialization;
        this.availableTime = availableTime;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public LocalTime getAvailableTime() {
        return availableTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setAvailableTime(LocalTime availableTime) {
        this.availableTime = availableTime;
    }
}
