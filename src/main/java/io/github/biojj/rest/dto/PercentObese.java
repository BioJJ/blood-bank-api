package io.github.biojj.rest.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class PercentObese {

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "totalObese")
    private BigDecimal totalObese;
    @Column(name = "percentageObese")
    private BigDecimal percentageObese;


    @Builder
    public PercentObese(BigDecimal total, BigDecimal totalObese, BigDecimal percentageObese){
        this.total = total;
        this.totalObese = totalObese;
        this.percentageObese = percentageObese;

    }
}
