package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.TariffDto;

import java.util.List;

public interface RegionService {
    Region findByTitle(String title);
    Region findById(Long id);
    List<Region> getAll();
    List<RegionDto> getListDto(List<Region> regions);
}
