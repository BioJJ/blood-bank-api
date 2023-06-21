package io.github.biojj.rest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PercentObese {

    private String total;
    private BigDecimal totalObese;
    private BigDecimal percentageObese;


    @Builder
    public PercentObeseMen(String total, BigDecimal totalObese, BigDecimal percentageObese){
        this.total = total;
        this.totalObese = totalObese;
        this.percentageObese = percentageObese;

    }
}
