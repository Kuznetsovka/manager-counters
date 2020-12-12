package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.RegionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceProxy implements RegionService {

    private final RegionService regionService;

    private List<RegionDto> regionListCache = null;

    public RegionServiceProxy(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public RegionDto findByTitle(String title) {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        for (RegionDto region : regionListCache) {
            if (region.getTitle ().equals (title)) return region;
        }
        return null;
    }

    @Override
    public RegionDto findById(Long id) {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        for (RegionDto region : regionListCache) {
            if (region.getId ().equals (id)) return region;
        }
        return null;
    }

    @Override
    public List<RegionDto> getAll() {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        return regionListCache;
    }
}
