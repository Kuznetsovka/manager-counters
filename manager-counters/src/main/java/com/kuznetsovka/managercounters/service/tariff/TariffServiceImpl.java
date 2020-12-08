package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.dto.CompanyDto;
import com.kuznetsovka.managercounters.dto.TariffDto;
import com.kuznetsovka.managercounters.mapper.CompanyMapper;
import com.kuznetsovka.managercounters.mapper.TariffMapper;
import com.kuznetsovka.managercounters.repo.CompanyRepository;
import com.kuznetsovka.managercounters.repo.TariffRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TariffServiceImpl implements TariffService {
    private final TariffMapper mapper = TariffMapper.MAPPER;
    private final TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    @Transactional
    public boolean save(TariffDto tariffDto) {
        tariffRepository.save(mapper.toTariff (tariffDto));
        return true;
    }

    @Override
    public Tariff getById(Long id) {
        return tariffRepository.findById(id).orElse(null);
    }

    @Override
    public Tariff findByName(String name) {
        return tariffRepository.findFirstByType(name);
    }

    @Override
    public TariffDto findById(Long id) {
        return mapper.fromTariff (tariffRepository.getOne (id));
    }

    @Override
    public void delete(Long id){
        tariffRepository.deleteById (id);
    }

    @Override
    public void save(Tariff tariff) {
        tariffRepository.save(tariff);
    }
}