package edu.icet.ecom.repository;

import edu.icet.ecom.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EmployeeDto extends JpaRepository<EmployeeEntity,Long> {
    EmployeeEntity findByName(String name);
    EmployeeEntity findByUserUserId(Long userId);



    List<EmployeeEntity> findAllByCompanyCompanyId(Long companyId);
}
