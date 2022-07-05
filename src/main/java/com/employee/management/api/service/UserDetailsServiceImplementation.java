package com.employee.management.api.service;

import com.employee.management.api.config.CustomUserDetails;
import com.employee.management.api.entity.Employee;
import com.employee.management.api.entity.User;
import com.employee.management.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Could not find user");

        return new CustomUserDetails(user);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
