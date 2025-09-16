package com.example.clinic.services;

import com.example.clinic.models.Doctor;
import com.example.clinic.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // ✅ Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // ✅ Get doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // ✅ Create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // ✅ Update an existing doctor
    public Optional<Doctor> updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetails.getName());
                    doctor.setSpecialization(doctorDetails.getSpecialization());
                    doctor.setAvailableTime(doctorDetails.getAvailableTime());
                    return doctorRepository.save(doctor);
                });
    }

    // ✅ Delete doctor
    public boolean deleteDoctor(Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctorRepository.delete(doctor);
                    return true;
                })
                .orElse(false);
    }
}
package com.example.clinic.services;

import com.example.clinic.models.Doctor;
import com.example.clinic.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // ✅ Get all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // ✅ Get doctor by ID
    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    // ✅ Create a new doctor
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // ✅ Update an existing doctor
    public Optional<Doctor> updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetails.getName());
                    doctor.setSpecialization(doctorDetails.getSpecialization());
                    doctor.setAvailableTime(doctorDetails.getAvailableTime());
                    return doctorRepository.save(doctor);
                });
    }

    // ✅ Delete doctor
    public boolean deleteDoctor(Long id) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctorRepository.delete(doctor);
                    return true;
                })
                .orElse(false);
    }
}
