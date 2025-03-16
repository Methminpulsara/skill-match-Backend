package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Skill {

    private Long skillId;
    private String name;
    private String proficiencyLevel;
    private Long employeeId;

}
