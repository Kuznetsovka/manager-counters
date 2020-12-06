package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
