package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.CompanyDto;
import com.kuznetsovka.managercounters.dto.TariffDto;

public interface TariffService {
    boolean save(TariffDto tariffDto);
    Tariff findByName(String name);
    TariffDto findById(Long id);
    void delete(Long id);
    void save(Tariff tariff);
    Tariff getById(Long id);
}
