package com.kuznetsovka.managercounters.dto;

public class ValueVolume extends ValueDto {
    public ValueVolume() {
        super();
        this.measureStrategy = new VolumeStrategy ();
    }
}
