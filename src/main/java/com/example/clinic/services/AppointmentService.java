import com.example.clinic.exception.ResourceNotFoundException; // Import your new exception
import java.util.Optional;
// ... other imports ...

public class AppointmentService {
    
    // ... repository injection ...
    
    public Appointment getAppointmentById(Long id) {
        
        Optional<Appointment> appointmentOptional = appointmentRepository.findById(id);
        
        // Use orElseThrow with the custom exception (Best Practice)
        return appointmentOptional.orElseThrow(
            () -> new ResourceNotFoundException("Appointment not found with ID: " + id)
        );
        
        // Alternatively, using an if-check:
        /*
        if (appointmentOptional.isEmpty()) {
            throw new ResourceNotFoundException("Appointment not found with ID: " + id);
        }
        return appointmentOptional.get();
        */
    }
    
    // Apply similar logic to your update and delete methods.
}
