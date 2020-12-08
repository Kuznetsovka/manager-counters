package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;

import java.math.BigDecimal;
import java.util.List;

public interface Mediator {
    void addValue(BigDecimal value);
    List<Counter> addCounters();
    void addHouse();
    void changeTariff();
}
