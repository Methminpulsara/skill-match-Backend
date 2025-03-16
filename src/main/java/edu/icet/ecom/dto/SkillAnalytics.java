package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class SkillAnalytics {

    private Long id;
    private String reportDate;
    private String skillDistribution;   // java 40 % , js30 %
    private String skillGaps;  // need ai
    private Long companyId;
}
