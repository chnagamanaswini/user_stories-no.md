package com.example.clinic.controllers;

import com.example.clinic.models.Prescription;
import com.example.clinic.models.Doctor;
import com.example.clinic.models.Patient;
import com.example.clinic.repositories.PrescriptionRepository;
import com.example.clinic.repositories.DoctorRepository;
import com.example.clinic.repositories.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    // ✅ Get all prescriptions
    @GetMapping
    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    // ✅ Get prescription by ID
    @GetMapping("/{id}")
    public ResponseEntity<Prescription> getPrescriptionById(@PathVariable Long id) {
        return prescriptionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ Create prescription
    @PostMapping
    public ResponseEntity<Prescription> createPrescription(
            @RequestParam Long doctorId,
            @RequestParam Long patientId,
            @RequestParam String medication) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Prescription prescription = new Prescription();
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        prescription.setMedication(medication);

        return ResponseEntity.ok(prescriptionRepository.save(prescription));
    }

    // ✅ Delete prescription
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrescription(@PathVariable Long id) {
        return prescriptionRepository.findById(id)
                .map(prescription -> {
                    prescriptionRepository.delete(prescription);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
