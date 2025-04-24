package edu.icet.ecom.repository;

import edu.icet.ecom.entity.TrainingProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface TrainingProgramsDto extends JpaRepository<TrainingProgramEntity, Long> {
    List<TrainingProgramEntity> findAllByName(String name);

    List<TrainingProgramEntity> findAllByCompanyCompanyIdAndStatus(Long companyId , String status);
}
