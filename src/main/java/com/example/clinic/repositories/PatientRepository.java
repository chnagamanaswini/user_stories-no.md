import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Assuming Patient and Long are the Entity and ID type
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // 1. Method to find a patient by email (Derived Query)
    Optional<Patient> findByEmail(String email);

    // 2. Method to find a patient by phone number (Derived Query)
    Optional<Patient> findByPhoneNumber(String phoneNumber);

    // Note: The 'Optional' wrapper is best practice for methods that might return null.
}
