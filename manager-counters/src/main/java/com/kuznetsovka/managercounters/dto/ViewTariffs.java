package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Type;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ViewTariffs {
    private Long tariff_id;
    private Type type;
    private BigDecimal price;
}
