package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional

@Entity
@Table (name = "user")
public class UserEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column (unique = true , nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Role role;

}
