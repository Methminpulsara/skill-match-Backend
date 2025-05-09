package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TrainingProgram {

    private Long trainingId;
    private String name;
    private String description;
    private Long companyId;
    private String startDate;
    private String endDate;
    private String status;
    private List<String> badges;

}
