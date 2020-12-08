package com.kuznetsovka.managercounters.domain;

import org.springframework.stereotype.Component;

public interface MeasureStrategy {
    /**
     * Выводит информацию единицу измерения значения
     * @return единицу измерения
     */
    String getMeasure();
}