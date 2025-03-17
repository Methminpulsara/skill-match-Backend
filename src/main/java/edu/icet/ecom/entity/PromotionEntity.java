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
@Table(name = "promotions")
public class PromotionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotionId;
    private String date;
    private String name;
    private String skillCriteria;

    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName = "companyId" ,nullable = false)
    private CompanyEntity company;
}
