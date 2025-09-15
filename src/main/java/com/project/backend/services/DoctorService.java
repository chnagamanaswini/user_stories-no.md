package com.project.backend.services;

import com.project.backend.models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    // Add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor);
    }

    // Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Get doctor by ID
    public Doctor getDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    // Update doctor details
    public boolean updateDoctor(int doctorId, String name, String specialization, String contactInfo) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctor.setName(name);
            doctor.setSpecialization(specialization);
            doctor.setContactInfo(contactInfo);
            return true;
        }
        return false;
    }

    // Delete doctor
    public boolean deleteDoctor(int doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctors.remove(doctor);
            return true;
        }
        return false;
    }
}
