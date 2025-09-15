package com.project.backend.repositories;

import com.project.backend.models.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private List<Patient> patients = new ArrayList<>();

    // Save patient
    public void save(Patient patient) {
        patients.add(patient);
        System.out.println("Patient saved: " + patient);
    }

    // Find all patients
    public List<Patient> findAll() {
        return patients;
    }

    // Find patient by ID
    public Patient findById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    // Update patient
    public boolean update(int patientId, String name, int age, String gender, String contactInfo) {
        Patient patient = findById(patientId);
        if (patient != null) {
            patient.setName(name);
            patient.setAge(age);
            patient.setGender(gender);
            patient.setContactInfo(contactInfo);
            return true;
        }
        return false;
    }

    // Delete patient
    public boolean delete(int patientId) {
        Patient patient = findById(patientId);
        if (patient != null) {
            patients.remove(patient);
            return true;
        }
        return false;
    }
}
