package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.House;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private String name;
    private String password;
    private List<House> houses;
}
