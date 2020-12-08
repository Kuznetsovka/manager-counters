package com.kuznetsovka.managercounters.service.counter;

import com.kuznetsovka.managercounters.domain.*;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.mapper.CounterMapper;
import com.kuznetsovka.managercounters.repo.CounterRepository;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private final CounterMapper mapper = (CounterMapper) CounterMapper.MAPPER;
    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    public List<Counter> create() {
        List counters= Arrays.asList (
                new Counter (null, Type.HOT_WATER,"1",null,null, null,LocalDateTime.now (),true),
                new Counter (null,Type.COLD_WATER,"2",null,null, null,LocalDateTime.now (),true),
                new Counter (null,Type.ELECTRICITY,"1",null,null, null,LocalDateTime.now (),true)
        );
        counterRepository.saveAll (counters);
        return counters;
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
}
