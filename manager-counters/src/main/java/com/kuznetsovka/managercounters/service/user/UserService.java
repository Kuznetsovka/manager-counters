package com.kuznetsovka.managercounters.service.user;

import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);
    User findByName(String name);
    List<UserDto> findAll();
    void delete(Long id);
    void save(User user);
    User getById(Long id);
    UserDto findById(Long id);
}
