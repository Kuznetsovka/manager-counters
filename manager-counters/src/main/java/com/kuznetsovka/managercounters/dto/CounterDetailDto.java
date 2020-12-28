package com.kuznetsovka.managercounters.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class CounterDetailDto {
    private BigDecimal price;
    private LocalDateTime lastDate;
    private BigDecimal lastValue;
    private BigDecimal newValue = BigDecimal.valueOf (0.0);
}
