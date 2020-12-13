package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.mapper.RegionMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceProxy implements RegionService {
    private final RegionMapper mapper = RegionMapper.MAPPER;
    private final RegionService regionService;
    private List<Region> regionListCache = null;

    public RegionServiceProxy(RegionService regionService) {
        this.regionService = regionService;
    }

    @Override
    public Region findByTitle(String title) {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        for (Region region : regionListCache) {
            if (region.getTitle ().equals (title)) return region;
        }
        return null;
    }

    @Override
    public Region findById(Long id) {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        for (Region region : regionListCache) {
            if (region.getId ().equals (id)) return region;
        }
        return null;
    }

    @Override
    public List<Region> getAll() {
        if(regionListCache == null) {
            regionListCache = regionService.getAll ();
        }
        return regionListCache;
    }

    @Override
    public List<RegionDto> getListDto(List<Region> regions) {
        return mapper.fromRegionList (regionListCache);
    }
}
