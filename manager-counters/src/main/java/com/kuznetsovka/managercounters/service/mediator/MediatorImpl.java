package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.TariffDto;
import com.kuznetsovka.managercounters.service.company.CompanyServiceImpl;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.house.HouseServiceImpl;
import com.kuznetsovka.managercounters.service.region.RegionServiceProxy;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceImpl;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceJdbcProxy;
import com.kuznetsovka.managercounters.service.user.UserServiceImpl;
import com.kuznetsovka.managercounters.service.value.ValueServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MediatorImpl implements Mediator {
    private ValueServiceImpl valueService;
    private RegionServiceProxy regionService;
    private CounterServiceImpl counterService;
    private TariffServiceJdbcProxy tariffService;
    private HouseServiceImpl houseService;
    private UserServiceImpl userService;
    private CompanyServiceImpl companyService;

    @Override
    public void addValue(BigDecimal value) {
        valueService.create(value);
    }

    @Override
    public List<Counter> addCounters() {
        return counterService.create();
    }

    @Override
    public boolean addHouse(HouseDto houseDto, List<CounterDto> counterDto, Long regionID, String name) {
        List<Tariff> tariffs = tariffService.findById (regionID);
        return false;
    }

    @Override
    public void changeTariff() {

    }
}
