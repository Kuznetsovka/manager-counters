package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.Counter;
import com.kuznetsovka.managercounters.domain.CounterDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterDetailRepository extends JpaRepository<CounterDetail, Long> {
}
