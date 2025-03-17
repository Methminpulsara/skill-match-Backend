package edu.icet.ecom.entity;

import edu.icet.ecom.dto.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "trainingPrograms")
public class TrainingProgramEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "companyId" ,referencedColumnName = "companyId" ,nullable = false)
    private CompanyEntity company;

    @ManyToMany
    @JoinTable(
            name = "training_enrollments",
            joinColumns = @JoinColumn(name = "trainingId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId")
    )
    private Set<EmployeeEntity> enrolledEmployeeId;



}
