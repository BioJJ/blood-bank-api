package io.github.biojj.rest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class AverageAgeByBloodType {

    private String bloodType;
    private BigDecimal average;

    @Builder
    public AverageAgeByBloodType(String bloodType, BigDecimal average){
        this.bloodType = bloodType;
        this.average = average;

    }
}
