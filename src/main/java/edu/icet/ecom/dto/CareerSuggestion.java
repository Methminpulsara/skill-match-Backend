package edu.icet.ecom.dto;

import java.util.List;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CareerSuggestion {

    private Long id ;
    private String title;
    private Integer matchPercentage;
    private String suggestionReason;
    private List<String> relevantSkills;

}
