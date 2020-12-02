package com.kuznetsovka.managercounters.factory;


import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.Measure;
import com.kuznetsovka.managercounters.dto.Measurement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ValueFactory {
    Measurement createValue(BigDecimal value, LocalDateTime date, Counter counter);
}
