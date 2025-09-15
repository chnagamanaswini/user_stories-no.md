package com.project.backend.services;

import com.project.backend.models.Appointment;
import com.project.backend.models.Doctor;
import com.project.backend.models.Patient;

import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    // Add an appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added: " + appointment);
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    // Find appointment by ID
    public Appointment getAppointmentById(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    // Update appointment details
    public boolean updateAppointment(int appointmentId, Patient patient, Doctor doctor, String date, String time) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setPatient(patient);
            appointment.setDoctor(doctor);
            appointment.setDate(date);
            appointment.setTime(time);
            return true;
        }
        return false;
    }

    // Delete appointment
    public boolean deleteAppointment(int appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointments.remove(appointment);
            return true;
        }
        return false;
    }
}
