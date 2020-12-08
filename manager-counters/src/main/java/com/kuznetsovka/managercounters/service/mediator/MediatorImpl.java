package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.service.company.CompanyServiceImpl;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.house.HouseServiceImpl;
import com.kuznetsovka.managercounters.service.region.RegionServiceImpl;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceImpl;
import com.kuznetsovka.managercounters.service.user.UserService;
import com.kuznetsovka.managercounters.service.user.UserServiceImpl;
import com.kuznetsovka.managercounters.service.value.ValueServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MediatorImpl implements Mediator {
    private ValueServiceImpl valueService;
    private CounterServiceImpl counterService;
    private TariffServiceImpl tariffService;
    private RegionServiceImpl regionService;
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
    public void addHouse() {

    }

    @Override
    public void changeTariff() {

    }
}
