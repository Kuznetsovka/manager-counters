package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.dto.HouseDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {CounterMapper.class,RegionMapper.class})
public interface HouseMapper {
    HouseMapper MAPPER = Mappers.getMapper(HouseMapper.class);

    @Mapping(source = "counters", target = "counters")
    @Mapping(source = "region", target = "region")
    House toHouse(HouseDto dto);
    List<House> toHouseList(List<HouseDto> houses);
    @InheritInverseConfiguration
    HouseDto fromHouse(House house);
    List<HouseDto> fromHouseList(List<House> houses);

}
