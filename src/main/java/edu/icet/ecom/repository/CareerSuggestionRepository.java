package edu.icet.ecom.repository;

import edu.icet.ecom.entity.CareerSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CareerSuggestionRepository extends JpaRepository<CareerSuggestionEntity,Long> {


    @Query("SELECT cs FROM CareerSuggestionEntity cs WHERE EXISTS " +
            "(SELECT skill FROM cs.relevantSkills skill WHERE skill IN :employeeSkills)")
    List<CareerSuggestionEntity> findSuggestionsByEmployeeSkills(@Param("employeeSkills") List<String> employeeSkills);
}
