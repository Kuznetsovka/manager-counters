package com.kuznetsovka.managercounters.service.counter;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;

public interface CounterService {
    boolean save(CounterDto counterDto);
    Counter findByName(String name);
    CounterDto findById(Long id);
    void delete(Long id);
    void save(Counter counter);
    Counter getById(Long id);
    Counter getCounterByDto(CounterDto counterDto);
}
