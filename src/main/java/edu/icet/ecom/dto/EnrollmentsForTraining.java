package edu.icet.ecom.dto;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentsForTraining {

    private Long enrollmentId;
    private Long trainingId;
    private Long employeeId;

}
