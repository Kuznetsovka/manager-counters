package com.kuznetsovka.managercounters.service.detail;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.CounterDetail;
import com.kuznetsovka.managercounters.dto.CounterDetailDto;
import com.kuznetsovka.managercounters.dto.CounterDto;

import java.util.List;

public interface DetailService {
    CounterDetailDto findById(Long id);
    boolean save(CounterDetail counterDetail);
}
