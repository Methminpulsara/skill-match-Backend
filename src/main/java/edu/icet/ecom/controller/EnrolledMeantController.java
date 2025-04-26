package edu.icet.ecom.controller;

import edu.icet.ecom.dto.EnrollmentsForTraining;
import edu.icet.ecom.service.EnrolledMeantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/enrollments")
public class EnrolledMeantController {

    private final EnrolledMeantService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody EnrollmentsForTraining enrollment){
        if (service.isAlreadyEnrolled(enrollment.getEmployeeId(), enrollment.getTrainingId())) {
            return ResponseEntity.badRequest().body("Already enrolled in this training.");
        }

        enrollment.setEnrollmentId(null);
        return ResponseEntity.ok(service.enroll(enrollment));
    }



    @GetMapping("/employee/{employeeId}")
    public List<EnrollmentsForTraining> getEnrollmentsByEmployeeId(@PathVariable Long employeeId) {
        return service.findByEmployeeId(employeeId);
    }





}
