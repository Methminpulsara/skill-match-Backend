package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "skills")
public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skillId;

    @Column(nullable = false)
    private String name;

    private String proficiencyLevel;
    private String description;
    private String status;
    private String time;
    @ManyToOne
    @JoinColumn(name = "employeeId" , referencedColumnName = "employeeId" , nullable = false)
    private EmployeeEntity employee;

}
