package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Person;
import com.kuznetsovka.managercounters.domain.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto extends Person {
    private String name;
    private String password;
    private List<House> houses;
}
