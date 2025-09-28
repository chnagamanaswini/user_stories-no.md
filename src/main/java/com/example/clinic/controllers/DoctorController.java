@GetMapping("/availability")
public ResponseEntity<?> getDoctorAvailability(
        @RequestParam String role,
        @RequestParam Long doctorId,
        @RequestParam String date,
        @RequestHeader("Authorization") String token) {

    // Validate token or role if required
    // Example logic
    if (!authService.validateToken(token)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token");
    }

    List<Availability> availabilityList = doctorService.getAvailability(doctorId, date);
    if (availabilityList.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No availability found");
    }
    return ResponseEntity.ok(availabilityList);
}
List<Availability> findByDoctorIdAndDate(Long doctorId, String date);
public List<Availability> getAvailability(Long doctorId, String date) {
    return availabilityRepository.findByDoctorIdAndDate(doctorId, date);
}
