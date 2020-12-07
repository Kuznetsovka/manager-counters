package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.TariffDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffMapper {
    TariffMapper MAPPER = Mappers.getMapper(TariffMapper.class);
    Tariff toTariff(TariffDto dto);
    List<Tariff> toTariffList(List<TariffDto> tariffs);
    @InheritInverseConfiguration
    TariffDto fromTariff(Tariff tariff);
    List<TariffDto> fromTariffList(List<Tariff> tariffs);

}
