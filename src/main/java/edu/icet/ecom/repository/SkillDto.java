package edu.icet.ecom.repository;

import edu.icet.ecom.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDto extends JpaRepository<SkillEntity , Long> {
}
