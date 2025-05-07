package edu.icet.ecom.repository;

import edu.icet.ecom.entity.EnrollmentsForTrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface EnrolledMeantDto extends JpaRepository<EnrollmentsForTrainingEntity,Long> {

    Optional<EnrollmentsForTrainingEntity> findByEmployeeIdAndTrainingId(Long employeeId, Long trainingId);

    List<EnrollmentsForTrainingEntity> findByEmployeeId(Long employeeId);

    List<EnrollmentsForTrainingEntity> findByTrainingId(Long trainingId);
}
