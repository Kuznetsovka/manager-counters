package com.kuznetsovka.managercounters.service.counter;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.CounterDto;

import java.util.List;

public interface CounterService {
    boolean save(CounterDto counterDto);
    Counter findByName(String name);
    CounterDto findById(Long id);
    void delete(Long id);
    boolean save(Counter counter);
    boolean saveAll(List<Counter> counters);
    Counter getById(Long id);
    Counter getCounterByDto(CounterDto counterDto);
}
