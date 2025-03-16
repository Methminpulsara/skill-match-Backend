package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import util.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class User {


    private Long UserId;
    private String userName;
    private String password;
    private Role role;

}
