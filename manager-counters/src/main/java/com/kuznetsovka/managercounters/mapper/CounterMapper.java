package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.dto.CounterDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ValueMapper.class})
public interface CounterMapper {
    ValueMapper MAPPER = Mappers.getMapper(ValueMapper.class);

    @Mapping(source = "values", target = "values")
    Counter toCounter(CounterDto dto);
    List<Counter> toCounterList(List<CounterDto> counters);
    @InheritInverseConfiguration
    CounterDto fromCounter(Counter counter);
    List<CounterDto> fromCounterList(List<Counter> counters);
}
