package edu.icet.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Promotion {
    private Long promotionId;
    private String date;
    private String name;
    private String skillCriteria;
    private Long companyId;
}
