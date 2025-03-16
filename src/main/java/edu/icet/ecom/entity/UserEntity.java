package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table( name = "users")

public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    private String userName;
    private String password;
    private Role role;


}
