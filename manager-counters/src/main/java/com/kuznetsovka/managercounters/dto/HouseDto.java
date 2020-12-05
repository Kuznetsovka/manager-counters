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
    private User user;
    private List<Company> companies;
    private Region region;
    private List<Counter> counters;

}