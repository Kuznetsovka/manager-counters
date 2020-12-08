package com.kuznetsovka.managercounters.domain;

public class VolumeStrategy implements MeasureStrategy {
    @Override
    public String getMeasure() {
        return "м³";
    }
}
