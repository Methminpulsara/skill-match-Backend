package edu.icet.ecom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name= "skillAnalytics")
public class SkillAnalyticsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportDate;
    private String skillDistribution;   // java 40 % , js30 %
    private String skillGaps;  // need ai

    @ManyToOne
    @JoinColumn(name = "companyId" , referencedColumnName = "companyId", nullable = false)
    private CompanyEntity company;
}
