package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Counter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValueDtoPower implements Measurement {
    private BigDecimal value;
    private LocalDateTime date;
    private Counter counter;

    @Override
    public String getMeasure() {
        return value + " кВт";
    }

}
