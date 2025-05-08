package edu.icet.ecom.service;


import edu.icet.ecom.dto.EnrollmentsForTraining;
import java.util.List;
public interface EnrolledMeantService {

    EnrollmentsForTraining enroll(EnrollmentsForTraining enrollments);
     boolean isAlreadyEnrolled(Long employeeId, Long trainingId);

     List<EnrollmentsForTraining> findByEmployeeId(Long employeeId);

    long getEmployeeCountForTraining(Long trainingId);
}
