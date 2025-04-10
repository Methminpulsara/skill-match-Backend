package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import edu.icet.ecom.util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table( name = "users")

public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;


}
