package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.service.company.CompanyServiceImpl;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.house.HouseServiceImpl;
import com.kuznetsovka.managercounters.service.region.RegionServiceProxy;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceImpl;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceJdbcImpl;
import com.kuznetsovka.managercounters.service.user.UserServiceImpl;
import com.kuznetsovka.managercounters.service.value.ValueServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter

@Component
public class MediatorImpl implements Mediator {
    private final ValueServiceImpl valueService;
    private final RegionServiceProxy regionService;
    private final CounterServiceImpl counterService;
    private final TariffServiceJdbcImpl tariffService;
    private final HouseServiceImpl houseService;
    private final UserServiceImpl userService;
    private final CompanyServiceImpl companyService;

    public MediatorImpl(ValueServiceImpl valueService, RegionServiceProxy regionService, CounterServiceImpl counterService, TariffServiceJdbcImpl tariffService, HouseServiceImpl houseService, UserServiceImpl userService, CompanyServiceImpl companyService) {
        this.valueService = valueService;
        this.regionService = regionService;
        this.counterService = counterService;
        this.tariffService = tariffService;
        this.houseService = houseService;
        this.userService = userService;
        this.companyService = companyService;
    }

    @Override
    public void addValue(BigDecimal value) {
        valueService.create(value);
    }

    @Override
    public boolean addCounters(List<Counter> list) {
        return counterService.saveAll (list);
    }

    @Override
    public boolean addHouse(HouseDto houseDto, List<CounterDto> counterDtoList, Long regionID, String name) {
        List<Tariff> tariffs = tariffService.findById (regionID);
        List<Counter> counters = counterService.getCounterByDto (counterDtoList);
        for (Counter counter : counters) {
            for (Tariff tariff : tariffs) {
                if(counter.getType ().equals (tariff.getType ())){
                    counter.setTariff (tariff);
                }
            }
        }
        addCounters(counters);
        houseDto.setCounters (counters);
        houseDto.setUser (userService.findByName(name));
        houseDto.setRegion (regionService.findById (regionID));
        return houseService.save (houseDto);
    }

    @Override
    public void changeTariff() {

    }
}
