package com.example.demo.repository;

import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Retrieve patient by email (derived query)
    Optional<Patient> findByEmail(String email);

    // Retrieve patient using either email or phone number (custom query)
    Optional<Patient> findByEmailOrPhone(String email, String phone);
}
