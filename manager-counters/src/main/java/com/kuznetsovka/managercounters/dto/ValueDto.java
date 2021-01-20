package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValueDto {
    private BigDecimal value = BigDecimal.valueOf (0.0);
    private LocalDateTime date;
    private Type type;
    MeasureStrategy measureStrategy;
    private Counter counter;

    public void getMeasure(){
        measureStrategy.getMeasure ();
    }
}
