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
    private String name;
    private String phoneNumber;
    private String location;
    private String position;
    private String profileImage;
    private String department;
    private Long userid;
    private Long companyid;

}
