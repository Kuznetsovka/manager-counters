package com.kuznetsovka.managercounters.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueDto {
    private BigDecimal value;
    private LocalDateTime date;
    MeasureStrategy measureStrategy;

    public void getMeasure(){
        measureStrategy.getMeasure ();
    }
}
