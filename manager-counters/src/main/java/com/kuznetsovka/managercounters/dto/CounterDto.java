package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Tariff;
import com.kuznetsovka.managercounters.domain.Type;
import com.kuznetsovka.managercounters.domain.Value;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CounterDto {
    private Type type;
    private String name;
    private Tariff tariff;
    private House house;
    private List<Value> values;
    private LocalDateTime dateChecking;
    boolean isChecking;
}
