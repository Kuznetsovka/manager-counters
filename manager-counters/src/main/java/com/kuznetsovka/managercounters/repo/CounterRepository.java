package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Company;
import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CounterRepository extends JpaRepository<Counter, Long> {
    List<Counter> findAllByHouse(House house);
}
