package edu.icet.ecom.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class ProfileImage {

    private Long id ;
    private Long userId;
    private String url;


}
