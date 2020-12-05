package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TariffDto {
    private Type type;
    private BigDecimal price;
    private Region region;
    private List<Counter> counters;

}
