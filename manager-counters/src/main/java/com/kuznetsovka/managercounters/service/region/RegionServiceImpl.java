package com.kuznetsovka.managercounters.service.region;

import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.dto.TariffDto;
import com.kuznetsovka.managercounters.mapper.RegionMapper;
import com.kuznetsovka.managercounters.mapper.TariffMapper;
import com.kuznetsovka.managercounters.repo.RegionRepository;
import com.kuznetsovka.managercounters.repo.TariffRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegionServiceImpl implements RegionService {
    private final RegionMapper mapper = RegionMapper.MAPPER;
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    @Transactional
    public boolean save(RegionDto regionDto) {
        regionRepository.save(mapper.toRegion (regionDto));
        return true;
    }

    @Override
    public Region getById(Long id) {
        return regionRepository.findById(id).orElse(null);
    }

    @Override
    public Region findByTitle(String title) {
        return regionRepository.findFirstByTitle(title);
    }

    @Override
    public RegionDto findById(Long id) {
        return mapper.fromRegion (regionRepository.getOne (id));
    }

    @Override
    public void delete(Long id){
        regionRepository.deleteById (id);
    }

    @Override
    public void save(Region region) {
        regionRepository.save(region);
    }
}
