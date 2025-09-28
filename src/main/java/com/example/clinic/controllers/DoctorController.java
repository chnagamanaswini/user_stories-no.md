import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
// ... other imports ...

// Example correct method using Path Variables
@GetMapping("/users/{userId}/doctors/{doctorId}/available/{date}/{token}")
public ResponseEntity<?> checkAvailability(
    @PathVariable Long userId,          // Extracts the 'userId' from the URL path
    @PathVariable Long doctorId,        // Extracts the 'doctorId' from the URL path
    @PathVariable String date,          // Extracts the 'date' from the URL path
    @PathVariable String token          // Extracts the 'token' from the URL path
) {
    // ... your original method logic goes here, using the variables ...
    // Note: The structure might vary slightly, but the key is using @PathVariable.
    
    // Example logic return:
    // return ResponseEntity.ok("Doctor availability checked successfully for " + doctorId);
}
