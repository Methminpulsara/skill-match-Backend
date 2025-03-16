package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private Long userId;   // User user
    private Long companyId;  // Company com

}
