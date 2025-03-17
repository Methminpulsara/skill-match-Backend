package edu.icet.ecom.repository;

import edu.icet.ecom.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionDto extends JpaRepository<PromotionEntity, Long> {
    PromotionEntity findByName(String name);
}
