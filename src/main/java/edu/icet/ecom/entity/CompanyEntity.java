package edu.icet.ecom.entity;

import edu.icet.ecom.dto.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    private String industry;
    private String location;

    @OneToOne
    @JoinColumn(name = "userId" , referencedColumnName = "userId" , nullable = false)
    private User user;
}
