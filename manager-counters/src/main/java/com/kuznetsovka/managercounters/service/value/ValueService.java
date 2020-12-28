package com.kuznetsovka.managercounters.service.value;

import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.ValueDto;

import java.util.List;

public interface ValueService {
    boolean save(ValueDto dto);
    void saveAll(List<ValueDto> books);
    List<Value> findAll();
}
