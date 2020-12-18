package com.kuznetsovka.managercounters.dto;

public class PowerStrategy implements MeasureStrategy {
    @Override
    public String getMeasure() {
        return "кВт";
    }
}
