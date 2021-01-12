package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Counter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ValuesCreationDto {
    private List<ValueDto> values;
    private List<BigDecimal> oldValues;
    public ValuesCreationDto() {
        this.values = new ArrayList<> ();
    }

    public void addValues(List<Counter> counters) {
        for (Counter counter : counters) {
            ValueDto valueDto = ValueDto.builder()
                    .type (counter.getType ())
                    .build ();
            oldValues.add(counter.getDetail ().getOldValue ());
            this.values.add (valueDto);
        }
    }

    public void clearValues() {
        values.clear ();
        oldValues.clear();
    }


    public List<ValueDto> getValues() {
        return values;
    }

    public void setValues(List<ValueDto> values) {
        this.values = values;
    }
}