package com.kuznetsovka.managercounters.factory;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.Measure;
import com.kuznetsovka.managercounters.dto.Measurement;
import com.kuznetsovka.managercounters.dto.ValueDtoVolume;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VolumeValueFactory implements ValueFactory {
    @Override
    public Measurement createValue(BigDecimal value, LocalDateTime date, Counter counter) {
        return new ValueDtoVolume (value,date,counter);
    }
}
