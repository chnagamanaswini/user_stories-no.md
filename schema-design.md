# Database Schema Design - Smart Clinic Management System

## Tables and Relationships

### 1. Doctors
- `doctor_id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `specialization` (VARCHAR)
- `contact_info` (VARCHAR)

### 2. Patients
- `patient_id` (INT, Primary Key, Auto Increment)
- `name` (VARCHAR)
- `age` (INT)
- `gender` (VARCHAR)
- `contact_info` (VARCHAR)

### 3. Admins
- `admin_id` (INT, Primary Key, Auto Increment)
- `username` (VARCHAR, Unique)
- `password` (VARCHAR)

### 4. Appointments
- `appointment_id` (INT, Primary Key, Auto Increment)
- `doctor_id` (INT, Foreign Key → Doctors.doctor_id)
- `patient_id` (INT, Foreign Key → Patients.patient_id)
- `appointment_date` (DATETIME)
- `status` (VARCHAR)  -- (e.g., Scheduled, Completed, Cancelled)

### 5. Prescriptions
- `prescription_id` (INT, Primary Key, Auto Increment)
- `appointment_id` (INT, Foreign Key → Appointments.appointment_id)
- `doctor_id` (INT, Foreign Key → Doctors.doctor_id)
- `patient_id` (INT, Foreign Key → Patients.patient_id)
- `medicines` (TEXT)
- `instructions` (TEXT)

## Relationships
- One Doctor → Many Appointments
- One Patient → Many Appointments
- One Appointment → One Prescription
