package com.kuznetsovka.managercounters.service.detail;

import com.kuznetsovka.managercounters.domain.CounterDetail;
import com.kuznetsovka.managercounters.dto.CounterDetailDto;
import com.kuznetsovka.managercounters.repo.CounterDetailRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DetailServiceImpl implements DetailService {
    private final CounterDetailRepository counterDetailRepository;

    public DetailServiceImpl(CounterDetailRepository counterDetailRepository) {
        this.counterDetailRepository = counterDetailRepository;
    }

    @Override
    public CounterDetailDto findById(Long id) {
        return null;
    }

    @Override
    @Transactional
    public boolean save(CounterDetail counterDetail) {
        counterDetailRepository.save (counterDetail);
        return false;
    }
}
