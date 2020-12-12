package com.kuznetsovka.managercounters.service.house;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.RegionDto;
import com.kuznetsovka.managercounters.mapper.HouseMapper;
import com.kuznetsovka.managercounters.repo.HouseRepository;
import com.kuznetsovka.managercounters.repo.RegionRepository;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.mediator.Mediator;
import com.kuznetsovka.managercounters.service.mediator.MediatorImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseMapper mapper = HouseMapper.MAPPER;
    private final MediatorImpl mediator;
    private final HouseRepository houseRepository;

    public HouseServiceImpl(MediatorImpl mediator, HouseRepository houseRepository) {
        this.mediator = mediator;
        this.houseRepository = houseRepository;
    }

//    private void InitBDUser() {
//        RegionDto reg = mediator.getRegionService ().findById ((long) 1);
//        if (!houseRepository.existsById ((long) 1)) {
//            House house = House.builder()
//                    .address("г. Балашиха, ул. Заречная, д. 40, кв. 40")
//                    .region (reg)
//                    .build();
//            houseRepository.save (house);
//        }
//    }

    @Override
    @Transactional
    public boolean save(HouseDto houseDto) {
        houseRepository.save(mapper.toHouse (houseDto));
        return true;
    }

    @Override
    public House getById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public House findByAddress(String address) {
        return houseRepository.findFirstByAddress(address);
    }

    @Override
    public HouseDto findById(Long id) {
        return mapper.fromHouse(houseRepository.getOne (id));
    }

    @Override
    public void delete(Long id){
        houseRepository.deleteById (id);
    }

    @Override
    public void save(House house) {
        houseRepository.save(house);
    }
}
