package com.kuznetsovka.managercounters.service.tariff;

import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.dto.TariffDto;
import com.kuznetsovka.managercounters.mapper.TariffMapper;
import com.kuznetsovka.managercounters.repo.TariffRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TariffServiceImpl implements TariffService {
    private final TariffMapper mapper = TariffMapper.MAPPER;
    private final TariffRepository tariffRepository;
    private final TariffServiceJdbcImpl tariffServiceJdbc;

    public TariffServiceJdbcImpl getTariffServiceJdbc() {
        return tariffServiceJdbc;
    }



    public TariffServiceImpl(TariffRepository tariffRepository, TariffServiceJdbcImpl tariffServiceJdbc) {
        this.tariffRepository = tariffRepository;
        this.tariffServiceJdbc = tariffServiceJdbc;
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
    public Tariff findByType(Type type) {
        return tariffRepository.findFirstByType(type);
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
