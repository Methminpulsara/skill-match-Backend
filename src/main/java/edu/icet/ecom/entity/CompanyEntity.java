package edu.icet.ecom.entity;

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
@Table (name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long companyId;
    private String name;
    private String industry;
    private String location;

    private User user;


}
