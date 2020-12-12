package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;

import java.math.BigDecimal;
import java.util.List;

public interface Mediator {
    void addValue(BigDecimal value);
    List<Counter> addCounters();
    boolean addHouse(HouseDto houseDto, List<CounterDto> counterDto, Long regionID, String name);
    void changeTariff();
}
