package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Company {

    private Long companyId;
    private String name;
    private String industry;
    private String location;
    private String size;
    private String profileImage;
    private Long userId;
}
