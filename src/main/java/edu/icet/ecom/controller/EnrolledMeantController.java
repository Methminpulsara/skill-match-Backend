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

    @GetMapping("/training/{trainingId}")
    public List<EnrollmentsForTraining> getTrainingEnrollments(@PathVariable Long trainingId) {
        return service.getAllByTrainingId(trainingId);
    }


    @GetMapping("/count/{trainingId}")
    public ResponseEntity<Long> getEnrollmentCount(@PathVariable Long trainingId) {
        long count = service.getEmployeeCountForTraining(trainingId);
        return ResponseEntity.ok(count);
    }






}
