package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.TariffDto;

import java.util.List;

public interface RegionService {
    RegionDto findByTitle(String title);
    RegionDto findById(Long id);
    List<RegionDto> getAll();
}
