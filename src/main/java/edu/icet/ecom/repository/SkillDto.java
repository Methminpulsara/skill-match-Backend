package edu.icet.ecom.repository;

import edu.icet.ecom.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface SkillDto extends JpaRepository<SkillEntity , Long> {

    List<SkillEntity> findAllByName(String name);
    List<SkillEntity> findAllByEmployeeEmployeeId(Long employeeId);
}
