package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.TariffDto;

public interface RegionService {
    boolean save(RegionDto regionDto);
    Region findByTitle(String title);
    RegionDto findById(Long id);
    void delete(Long id);
    void save(Region region);
    Region getById(Long id);
}
