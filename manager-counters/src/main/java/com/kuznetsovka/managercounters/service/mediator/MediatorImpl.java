package com.kuznetsovka.managercounters.service.mediator;

import com.kuznetsovka.managercounters.domain.*;
import com.kuznetsovka.managercounters.dto.CounterDto;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.service.company.CompanyServiceImpl;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.detail.DetailServiceImpl;
import com.kuznetsovka.managercounters.service.house.HouseServiceImpl;
import com.kuznetsovka.managercounters.service.region.RegionServiceProxy;
import com.kuznetsovka.managercounters.service.tariff.TariffServiceImpl;
import com.kuznetsovka.managercounters.service.user.UserServiceImpl;
import com.kuznetsovka.managercounters.service.value.ValueServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter

@Component
public class MediatorImpl implements Mediator {
    private final ValueServiceImpl valueService;
    private final RegionServiceProxy regionService;
    private final CounterServiceImpl counterService;
    private final TariffServiceImpl tariffService;
    private final HouseServiceImpl houseService;
    private final UserServiceImpl userService;
    private final CompanyServiceImpl companyService;
    private final DetailServiceImpl detailService;

    public MediatorImpl(ValueServiceImpl valueService, RegionServiceProxy regionService, CounterServiceImpl counterService, TariffServiceImpl tariffService, HouseServiceImpl houseService, UserServiceImpl userService, CompanyServiceImpl companyService, DetailServiceImpl detailService) {
        this.valueService = valueService;
        this.regionService = regionService;
        this.counterService = counterService;
        this.tariffService = tariffService;
        this.houseService = houseService;
        this.userService = userService;
        this.companyService = companyService;
        this.detailService = detailService;
    }

    public List<Value> addValue(BigDecimal value) {
        List<Value> valueList = new LinkedList<> ();
        Value val = new Value();
        val.setValue (value);
        valueList.add (val);
        return valueList;
    }

    @Override
    public boolean addHouse(HouseDto houseDto, List<CounterDto> counterDtoList, Long regionID, String name) {
        List<Tariff> tariffs = tariffService.getTariffServiceJdbc ().findById (regionID);
        List<Counter> counters = counterService.getCountersByDto (counterDtoList);
        houseDto.setUser (userService.findByName(name));
        houseDto.setRegion (regionService.findById (regionID));
        House house = houseService.save (houseDto);
        addCounters (tariffs, counters, house);
        return true;
    }

    @Override
    public boolean addValues(List<ValueDto> values, String address) {
        List<Counter> counters = counterService.getCountersByHouse (houseService.findByAddress (address));
        for (ValueDto value : values) {
            for (Counter counter : counters) {
                if (value.getType ().equals (counter.getType ())){
                    counter.setValues (Collections.singletonList (valueService.getMapper ().toValue (value)));
                    counter.setDetail (CounterDetail.builder().oldValue (value.getValue ()).build());
                    //TODO Проверить запить деталей
                   // value.setCounter (counterService.getById (counter.getId ()));
                }
            }
        }
        valueService.saveAll (values);
        return true;
    }

    public void addCounters(List<Tariff> tariffs, List<Counter> counters, House house) {
        CounterDetail detail;
        for (Counter counter : counters) {
            for (Tariff tariff : tariffs) {
                if(counter.getType ().equals (tariff.getType ())){
                    List<Value> valueList = addValue(BigDecimal.valueOf (0.0));
                    counter.setValues (valueList);
                    counter.setTariff (tariffService.getById (tariff.getId ()));
                    counter.setChecking (true);
                    counter.setHouse (house);
                    detail = addCounterDetail (counter, tariff, valueList);
                    counterService.save (counter);
                    counter.setDetail (detail);
                    detailService.save (detail);
                }
            }
        }


    }

    private CounterDetail addCounterDetail(Counter counter, Tariff tariff, List<Value> valueList) {
        CounterDetail detail =  new CounterDetail ();
        detail.setCounter (counter);
        detail.setOldValue (getLastValue (valueList).getValue ());
        detail.setPrice (tariff.getPrice ());
        detail.setLastDate (getLastValue (valueList).getDate ());
        return detail;
    }

    private Value getLastValue(List<Value> valueList) {
        return valueList.get (valueList.size ()-1);
    }

    @Override
    public void changeTariff() {

    }
}
