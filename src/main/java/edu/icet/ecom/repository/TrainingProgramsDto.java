package edu.icet.ecom.repository;

import edu.icet.ecom.entity.TrainingProgramEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface TrainingProgramsDto extends JpaRepository<TrainingProgramEntity, Long> {
    List<TrainingProgramEntity> findAllByName(String name);

    List<TrainingProgramEntity> findAllByCompanyCompanyIdAndStatus(Long companyId , String status);

}
