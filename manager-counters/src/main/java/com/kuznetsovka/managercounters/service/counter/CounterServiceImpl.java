package com.kuznetsovka.managercounters.service.counter;

import com.kuznetsovka.managercounters.domain.*;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.mapper.CounterMapper;
import com.kuznetsovka.managercounters.repo.CounterRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CounterServiceImpl implements CounterService {
    private final CounterMapper mapper = CounterMapper.MAPPER;
    private final CounterRepository counterRepository;

    public CounterServiceImpl(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    @Override
    @Transactional
    public boolean save(CounterDto counterDto) {
        counterRepository.save (mapper.toCounter (counterDto));
        return true;
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
    @Transactional
    public void delete(Long id) {

    }

    @Override
    @Transactional
    public boolean save(Counter counter) {
            counterRepository.save (counter);
        return true;
    }


    @Override
    public Counter getById(Long id) {
        return null;
    }

    public List<Counter> getCountersByDto(List<CounterDto> counterDtoList) {
        return mapper.toCounterList (counterDtoList);
    }


    @Transactional
    public boolean saveAll(List<Counter> counters) {
        List<Counter> list = counterRepository.saveAll (counters);
        return (!list.isEmpty ());
    }
}
