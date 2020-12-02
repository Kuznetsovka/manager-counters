package com.kuznetsovka.managercounters.service.value;

import com.kuznetsovka.managercounters.dto.Measurement;
import com.kuznetsovka.managercounters.factory.PowerValueFactory;
import com.kuznetsovka.managercounters.factory.ValueFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ValueServiceImpl implements ValueService {
    private ValueFactory factory;

    public ValueServiceImpl(ValueFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        ValueService valueService = new ValueServiceImpl(new PowerValueFactory ());
        System.out.println(valueService.showValueInfo ());
    }
    @Override
    public String showValueInfo() {
        Measurement dtoValue = factory.createValue (BigDecimal.valueOf (101), LocalDateTime.now (),null);
        return dtoValue.getMeasure ();
    }
}
