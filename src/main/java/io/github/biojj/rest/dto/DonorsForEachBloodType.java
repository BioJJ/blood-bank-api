package io.github.biojj.rest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class DonorsForEachBloodType {

    private String receiver;
    private BigDecimal quantity;

    @Builder
    public DonorsForEachBloodType(String receiver, BigDecimal quantity){
        this.receiver = receiver;
        this.quantity = quantity;

    }
}
