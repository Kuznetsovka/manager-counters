package com.kuznetsovka.managercounters.service.value;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.domain.Value;
import com.kuznetsovka.managercounters.domain.ValuePower;
import com.kuznetsovka.managercounters.dto.ValueDto;
import com.kuznetsovka.managercounters.mapper.ValueMapper;
import com.kuznetsovka.managercounters.repo.ValueRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {
    private final ValueRepository valueRepository;
    private final ValueMapper mapper = ValueMapper.MAPPER;

    public ValueServiceImpl(ValueRepository valueRepository) {
        this.valueRepository = valueRepository;
    }

    public void create(BigDecimal val) {
        Value value = new ValuePower ();
        Value.builder()
            .value (val)
            .build ();
        //System.out.println (value.getMeasureStrategy ().getMeasure ());
        valueRepository.save (value);
    }

    @Override
    @Transactional
    public boolean save(ValueDto dto) {
        valueRepository.save(mapper.toValue (dto));
        return true;
    }
}
