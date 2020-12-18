package com.kuznetsovka.managercounters.dto;

import org.springframework.stereotype.Component;

public interface MeasureStrategy {
    /**
     * Выводит информацию единицу измерения значения
     * @return единицу измерения
     */
    String getMeasure();
}