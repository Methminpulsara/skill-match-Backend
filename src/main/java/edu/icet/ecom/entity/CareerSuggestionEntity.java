package edu.icet.ecom.entity;

import edu.icet.ecom.dto.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table (name = "CareerSuggestion")
public class CareerSuggestionEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    private String title;
    private Integer matchPercentage;

    @Column(length = 500)
    private String suggestionReason;

    @ElementCollection
    private List<String> relevantSkills;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

}
