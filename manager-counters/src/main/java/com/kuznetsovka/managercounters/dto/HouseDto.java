package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.User;
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
public class HouseDto {
    private String address;
    private Region region;
    private Integer region_id;
    private List<Counter> counters;
    private User user;
    private Company company;
    private int countCounter;
}
