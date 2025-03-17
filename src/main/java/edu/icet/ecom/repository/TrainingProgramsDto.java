package edu.icet.ecom.repository;

import edu.icet.ecom.entity.TrainingProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainingProgramsDto extends JpaRepository<TrainingProgramEntity, Long> {
}
