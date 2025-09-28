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


import java.time.LocalDate;
import java.util.List;
// ... other imports ...

public class DoctorService {
    
    // ... repository and other fields ...

    /**
     * Retrieves the list of available time slots for a doctor on a specific date.
     * This logic will typically query the AppointmentRepository to find occupied slots.
     */
    public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        // 1. Logic to calculate available time slots (e.g., from 9am to 5pm)
        // 2. Query the AppointmentRepository to find all appointments for this doctor and date.
        // 3. Subtract the booked slots from the total possible slots.
        
        // This is a placeholder return; your actual implementation will vary.
        return List.of("09:00", "10:00", "14:00", "15:00");
    }
    
    // ... other methods ...
}



// ... other imports ...

public class DoctorService {
    
    // ...
    
    /**
     * Validates a doctor's login credentials (e.g., email and password).
     */
    public boolean validateLogin(String email, String password) {
        // 1. Use DoctorRepository to find the doctor by email.
        // 2. Check if the doctor exists and if the provided password matches (after decoding/hashing).
        
        // Example logic:
        // Optional<Doctor> doctor = doctorRepository.findByEmail(email);
        // return doctor.isPresent() && doctor.get().getPassword().equals(password);
        
        return true; // Placeholder
    }
    
    // ... other methods ...
}
