import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
// ... other imports ...

@PostMapping
public ResponseEntity<Prescription> createPrescription(
    @RequestBody PrescriptionRequest request // Use the DTO or the Prescription Entity
) {
    // 1. Access data using the request object's getters:
    Long patientId = request.getPatientId();
    String details = request.getMedicationDetails();
    
    // 2. Pass the data to your service layer...
    // Prescription newPrescription = prescriptionService.create(request);
    
    // 3. Return the created resource
    // return new ResponseEntity<>(newPrescription, HttpStatus.CREATED);
    return ResponseEntity.ok(/* ... your result ... */);
}
