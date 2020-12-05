package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.TariffDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CounterMapper.class,RegionMapper.class})
public interface TariffMapper {
    TariffMapper MAPPER = Mappers.getMapper(TariffMapper.class);

    @Mapping(source = "counters", target = "counters")
    @Mapping(source = "region", target = "region")
    Tariff toTariff(TariffDto dto);
    @InheritInverseConfiguration
    TariffDto fromTariff(Tariff tariff);

}
