package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findFirstByName(String name);
}
