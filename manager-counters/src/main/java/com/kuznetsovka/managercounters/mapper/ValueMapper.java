package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.ValueDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.factory.Mappers;

import java.util.List;


public interface ValueMapper {
    ValueMapper MAPPER = Mappers.getMapper(ValueMapper.class);

    Value toValue(ValueDto dto);
    List<Value> toValueList(List<ValueDto> values);

    @InheritInverseConfiguration
    ValueDto fromValue(Value value);
    List<ValueDto> fromValueList(List<Value> values);

}
