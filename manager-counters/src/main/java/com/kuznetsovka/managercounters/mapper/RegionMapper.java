package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.RegionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TariffMapper.class})
public interface RegionMapper {
    RegionMapper MAPPER = Mappers.getMapper(RegionMapper.class);

    @Mapping(source = "tariffs", target = "tariffs")
    Region toRegion(RegionDto dto);
    @InheritInverseConfiguration
    RegionDto fromRegion(Region region);
}
