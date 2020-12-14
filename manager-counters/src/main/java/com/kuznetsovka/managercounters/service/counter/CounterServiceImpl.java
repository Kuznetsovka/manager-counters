package com.kuznetsovka.managercounters.service.counter;

import com.kuznetsovka.managercounters.domain.*;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.mapper.CounterMapper;
import com.kuznetsovka.managercounters.repo.CounterRepository;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private final CounterMapper mapper = CounterMapper.MAPPER;
    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    public boolean save(CounterDto counterDto) {
        return false;
    }

    @Override
    public Counter findByName(String name) {
        return null;
    }

    @Override
    public CounterDto findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void save(Counter counter) {

    }

    @Override
    public Counter getById(Long id) {
        return null;
    }

    @Override
    public Counter getCounterByDto(CounterDto counterDto) {
        return mapper.toCounter (counterDto);
    }

    public List<Counter> getCounterByDto(List<CounterDto> counterDtoList) {
        return mapper.toCounterList (counterDtoList);
    }

    @Transactional
    public boolean saveAll(List<Counter> counters) {
        List<Counter> list = counterRepository.saveAll (counters);
        return (!list.isEmpty ());
    }
}
