package com.kuznetsovka.managercounters.service.house;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.HouseDto;

public interface HouseService {
    House save(HouseDto houseDto);
    House findByAddress(String address);
    HouseDto findById(Long id);
    void delete(Long id);
    void save(House house);
    House getById(Long id);
    House getByDto(HouseDto houseDto);
    House findByUser(User user);
    House getHouseByDto(HouseDto houseDto);
    HouseDto getHouseDtoByHouse(House house);
}
