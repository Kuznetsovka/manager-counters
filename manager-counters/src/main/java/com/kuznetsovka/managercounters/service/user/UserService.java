package com.kuznetsovka.managercounters.service.user;

import com.kuznetsovka.managercounters.domain.User;
import com.kuznetsovka.managercounters.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean save(UserDto userDto);
    User findByName(String name);
    void delete(Long id);
    void save(User user);
    User getById(Long id);
}
