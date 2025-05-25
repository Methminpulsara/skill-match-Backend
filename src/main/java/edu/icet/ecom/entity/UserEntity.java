package edu.icet.ecom.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "email is required")
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "password is required")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;


}
