package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Region;
import com.kuznetsovka.managercounters.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
    Tariff findFirstByType(String tariff);
}
