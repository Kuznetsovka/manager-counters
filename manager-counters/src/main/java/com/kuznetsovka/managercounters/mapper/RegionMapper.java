package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.RegionDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {TariffMapper.class})
public interface RegionMapper {
    RegionMapper MAPPER = Mappers.getMapper(RegionMapper.class);

    Region toRegion(RegionDto dto);
    List<Region> toRegionList(List<RegionDto> regions);
    @InheritInverseConfiguration
    RegionDto fromRegion(Region region);
    List<RegionDto> fromRegionList(List<Region> regions);
}
