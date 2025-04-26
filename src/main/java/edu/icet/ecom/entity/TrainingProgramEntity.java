package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
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

    private String startDate;
    private String endDate;
    private String status;
    private List<String> badges;



}
