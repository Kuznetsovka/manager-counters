package com.kuznetsovka.managercounters.repo;

import com.kuznetsovka.managercounters.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByName(String name);
    List<User> findAllByName(String name);
    List<User> findAllByIdBetween(Long startId, Long endId);
    List<User> findAllByNameLike(String name);
}
