package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.*;
public interface CompanyDto extends JpaRepository<CompanyEntity, Long> {

    CompanyEntity findByUserUserId (Long userId);
   CompanyEntity findByName(String name);

    @Query("SELECT c FROM CompanyEntity c WHERE c.status = 'active'")
    List<CompanyEntity> findAllActiveCompanies();

}
