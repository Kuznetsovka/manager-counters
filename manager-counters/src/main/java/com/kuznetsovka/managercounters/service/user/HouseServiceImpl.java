package com.kuznetsovka.managercounters.service.user;

import com.kuznetsovka.managercounters.domain.*;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.mapper.HouseMapper;
import com.kuznetsovka.managercounters.repo.CounterRepository;
import com.kuznetsovka.managercounters.repo.HouseRepository;
import com.kuznetsovka.managercounters.repo.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    private final HouseMapper mapper = HouseMapper.MAPPER;
    private final HouseRepository houseRepository;
    private final CounterRepository counterRepository;
    private final UserRepository userRepository;

    public HouseServiceImpl(HouseRepository houseRepository, CounterRepository counterRepository, UserRepository userRepository) {
        this.houseRepository = houseRepository;
        this.counterRepository = counterRepository;
        this.userRepository = userRepository;
        InitBDUser();
    }
    //Пока костыль.
    private void InitBDUser() {
        if (!houseRepository.existsById ((long) 1)) {
            List counters= Arrays.asList (
                    new Counter (null,Type.HOT_WATER,"1",null,null,LocalDateTime.now (),true),
                    new Counter (null,Type.COLD_WATER,"2",null,null,LocalDateTime.now (),true),
                    new Counter (null,Type.ELECTRICITY,"1",null,null,LocalDateTime.now (),true)
            );
            counterRepository.saveAll (counters);
            House house = House.builder()
                    .address("г. Балашиха, ул. Заречная, д. 40, кв. 40")
                    .region (new Region())
                    .counters (counters)
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
