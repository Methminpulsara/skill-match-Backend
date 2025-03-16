package edu.icet.ecom.entity;

import edu.icet.ecom.dto.Company;
import edu.icet.ecom.dto.User;
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
@Table (name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String department;

    @OneToOne
    @JoinColumn(name = "userId" , referencedColumnName = "userId" , nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "companyId" , referencedColumnName = "companyId")
    private Company company;

}
