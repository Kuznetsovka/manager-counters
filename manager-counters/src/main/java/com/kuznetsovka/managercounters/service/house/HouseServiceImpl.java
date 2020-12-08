package com.kuznetsovka.managercounters.service.house;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.mapper.HouseMapper;
import com.kuznetsovka.managercounters.repo.HouseRepository;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.mediator.Mediator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseMapper mapper = HouseMapper.MAPPER;
    private final Mediator mediator;
    private final HouseRepository houseRepository;

    public HouseServiceImpl(Mediator mediator, HouseRepository houseRepository) {
        this.mediator = mediator;
        this.houseRepository = houseRepository;
        InitBDUser();
    }
    //Пока костыль.
    private void InitBDUser() {
        if (!houseRepository.existsById ((long) 1)) {
            House house = House.builder()
                    .address("г. Балашиха, ул. Заречная, д. 40, кв. 40")
                    .region (new Region())
                    .build();
            houseRepository.save (house);
        }
    }

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
