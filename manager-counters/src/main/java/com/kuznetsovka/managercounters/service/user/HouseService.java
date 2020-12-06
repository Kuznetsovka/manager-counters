package com.kuznetsovka.managercounters.service.user;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.HouseDto;

public interface HouseService {
    boolean save(HouseDto houseDto);
    House findByAddress(String address);
    HouseDto findById(Long id);
    void delete(Long id);
    void save(House house);
    House getById(Long id);

}
