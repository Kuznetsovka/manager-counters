package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Tariff;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {
    private Long id;
    private String title;
    private List<Tariff> tariffs;
}
