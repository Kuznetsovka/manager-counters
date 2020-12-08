package com.kuznetsovka.managercounters.mapper;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.dto.CompanyDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {HouseMapper.class})
public interface CompanyMapper {
    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);

    @Mapping(source = "houses", target = "houses")
    Company toCompany(CompanyDto dto);

    @InheritInverseConfiguration
    CompanyDto fromCompany(Company company);

}
