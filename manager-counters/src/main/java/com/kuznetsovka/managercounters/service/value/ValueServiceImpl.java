package com.kuznetsovka.managercounters.service.value;

import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.dto.ValuePower;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.mapper.ValueMapper;
import com.kuznetsovka.managercounters.repo.ValueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {
    private final ValueRepository valueRepository;

    public ValueMapper getMapper() {
        return mapper;
    }

    private final ValueMapper mapper = ValueMapper.MAPPER;

    public ValueServiceImpl(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    public void create(BigDecimal val) {
        ValueDto value = new ValuePower ();
        Value.builder()
            .value (val)
            .build ();
        System.out.println (value.getMeasureStrategy ().getMeasure ());
        valueRepository.save (mapper.toValue (value));
    }

    @Override
    @Transactional
    public boolean save(ValueDto dto) {
        valueRepository.save(mapper.toValue (dto));
        return true;
    }

    @Override
    @Transactional
    public void saveAll(List<ValueDto> values) {
        valueRepository.saveAll(mapper.toValueList (values));
    }

    @Override
    @Transactional
    public List<Value> findAll() {
        return valueRepository.findAll();
    }

    public List<Value> findAllByDto( List<ValueDto> valueDto) {
        return mapper.toValueList (valueDto);
    }
}
