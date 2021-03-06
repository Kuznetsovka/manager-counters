package com.kuznetsovka.managercounters.dto;

import com.kuznetsovka.managercounters.domain.House;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String password;
    private String matchingPassword;
    private String email;
    private List<House> houses;
}
