package com.kuznetsovka.managercounters.service.house;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.CounterDto;
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
    private final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {

        this.houseRepository = houseRepository;
    }

    @Override
    @Transactional
    public House save(HouseDto houseDto) {
        return houseRepository.save(mapper.toHouse (houseDto));
    }

    @Override
    public House getById(Long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public House getByDto(HouseDto houseDto) {
        return mapper.toHouse (houseDto);
    }

    @Override
    public House findByUser(User user) {
        return houseRepository.findByUser(user).orElse(null);
    }

    @Override
    public HouseDto getHouseByDto(House house) {
        return mapper.fromHouse (house);
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
