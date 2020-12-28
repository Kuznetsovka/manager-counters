package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.House;
import com.kuznetsovka.managercounters.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface HouseRepository extends JpaRepository<House, Long> {
    House findFirstByAddress(String address);
    Optional<House> findByUser(User user);
}
