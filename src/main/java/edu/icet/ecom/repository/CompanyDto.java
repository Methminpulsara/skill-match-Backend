package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDto extends JpaRepository<CompanyEntity, Long> {
    CompanyEntity findByName(String name);
}
