package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Region, Long> {
}
