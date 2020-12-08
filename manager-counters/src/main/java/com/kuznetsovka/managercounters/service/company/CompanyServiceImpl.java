package com.kuznetsovka.managercounters.service.company;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.dto.CompanyDto;
import com.kuznetsovka.managercounters.dto.HouseDto;
import com.kuznetsovka.managercounters.mapper.CompanyMapper;
import com.kuznetsovka.managercounters.mapper.HouseMapper;
import com.kuznetsovka.managercounters.repo.CompanyRepository;
import com.kuznetsovka.managercounters.repo.HouseRepository;
import com.kuznetsovka.managercounters.service.counter.CounterServiceImpl;
import com.kuznetsovka.managercounters.service.mediator.MediatorImpl;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper mapper = CompanyMapper.MAPPER;
    private final CompanyRepository companyRepository;
    private MediatorImpl mediator;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public boolean save(CompanyDto companyDto) {
        companyRepository.save(mapper.toCompany (companyDto));
        return true;
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public Company findByName(String name) {
        return companyRepository.findFirstByName(name);
    }

    @Override
    public CompanyDto findById(Long id) {
        return mapper.fromCompany(companyRepository.getOne (id));
    }

    @Override
    public void delete(Long id){
        companyRepository.deleteById (id);
    }

    @Override
    public void save(Company company) {
        companyRepository.save(company);
    }
}
