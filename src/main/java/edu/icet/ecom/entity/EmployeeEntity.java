package edu.icet.ecom.entity;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table  (name = "employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String phoneNumber;
    private String location;
    private String position;
    private String profileImage;
    private String department;

    @OneToOne
    @JoinColumn(name = "userId" , referencedColumnName =  "userId", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "companyId" , referencedColumnName = "companyId")
    private CompanyEntity company;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SkillEntity> skills;


}
