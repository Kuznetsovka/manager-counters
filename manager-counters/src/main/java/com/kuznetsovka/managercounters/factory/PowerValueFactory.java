package com.kuznetsovka.managercounters.factory;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.Measure;
import com.kuznetsovka.managercounters.dto.Measurement;
import com.kuznetsovka.managercounters.dto.ValueDtoPower;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PowerValueFactory implements ValueFactory {
    @Override
    public Measurement createValue(BigDecimal value, LocalDateTime date, Counter counter) {
        return new ValueDtoPower (value,date,counter);
    }
}
