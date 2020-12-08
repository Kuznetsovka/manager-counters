package com.kuznetsovka.managercounters.service.company;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.dto.CompanyDto;
import com.kuznetsovka.managercounters.dto.HouseDto;

public interface CompanyService {
    boolean save(CompanyDto companyDto);
    Company findByName(String name);
    CompanyDto findById(Long id);
    void delete(Long id);
    void save(Company company);
    Company getById(Long id);
}
