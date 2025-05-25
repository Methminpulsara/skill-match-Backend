package edu.icet.ecom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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

    @NotBlank(message = "name is requierd")
    @Size(max = 100)
    private String name;

    private String description;


    @ManyToOne
    @JoinColumn(name = "companyId" ,referencedColumnName = "companyId" ,nullable = false)
    private CompanyEntity company;

    private String startDate;
    private String endDate;
    private String status;
    private List<String> badges;

}
