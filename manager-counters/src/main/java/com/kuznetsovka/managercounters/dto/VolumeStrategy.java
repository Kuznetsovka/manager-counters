package com.kuznetsovka.managercounters.dto;

public class VolumeStrategy implements MeasureStrategy {
    @Override
    public String getMeasure() {
        return "м³";
    }
}
