package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;

import java.math.BigDecimal;
import java.util.List;

public interface Mediator {
    List<Value> addValue(BigDecimal value);
    void addCounters(List<Tariff> tariffs, List<Counter> counters, House house);
    boolean addHouse(HouseDto houseDto, List<CounterDto> counterDto, Long regionID, String name);
    void changeTariff();
}
