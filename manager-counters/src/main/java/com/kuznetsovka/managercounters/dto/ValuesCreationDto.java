package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Counter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValuesCreationDto {
    private BigDecimal oldValue;
    public Map<Long,ValueDto> map;

    public void addValues(List<Counter> counters) {
        for (Counter counter : counters) {
            ValueDto valueDto = ValueDto.builder()
                    .value (BigDecimal.valueOf (0.0))
                    .type (counter.getType ())
                    .build ();
            map.put(counter.getId (),valueDto);
            int lastIndex = counter.getValues ().size ()-1;
            this.oldValue = counter.getValues().get (lastIndex).getValue ();
        }
    }

    public BigDecimal getOldValue() {
        return oldValue;
    }

    public void setOldValue(BigDecimal oldValue) {
        this.oldValue = oldValue;
    }

    public Map<Long, ValueDto> getMap() {
        return map;
    }

    public void setMap(Map<Long, ValueDto> map) {
        this.map = map;
    }

    public ValuesCreationDto() {
        this.map = new HashMap ();
    }

}