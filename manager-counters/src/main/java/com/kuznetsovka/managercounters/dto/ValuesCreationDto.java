package com.kuznetsovka.managercounters.dto;

import java.util.ArrayList;
import java.util.List;

public class ValuesCreationDto {
    private List<ValueDto> values;

    public ValuesCreationDto() {
        this.values = new ArrayList<>();
    }

    public ValuesCreationDto(List<ValueDto> values) {
        this.values = values;
    }

    public List<ValueDto> getValues() {
        return values;
    }

    public void setValues(List<ValueDto> values) {
        this.values = values;
    }

    public void addValue(ValueDto value) {
        this.values.add(value);
    }

}