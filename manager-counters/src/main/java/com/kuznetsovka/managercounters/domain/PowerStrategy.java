package com.kuznetsovka.managercounters.domain;

public class PowerStrategy implements MeasureStrategy {
    @Override
    public String getMeasure() {
        return "кВт";
    }
}
