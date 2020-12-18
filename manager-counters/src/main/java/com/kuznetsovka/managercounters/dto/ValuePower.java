package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.ValueDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
public class ValuePower extends ValueDto {
    public ValuePower() {
        super();
        this.measureStrategy = new VolumeStrategy ();
    }
}
