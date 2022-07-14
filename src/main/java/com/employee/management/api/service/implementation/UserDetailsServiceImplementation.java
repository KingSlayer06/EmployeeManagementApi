package com.employee.management.api.service.implementation;

import com.employee.management.api.config.CustomUserDetails;
import com.employee.management.api.entity.Employee;
import com.employee.management.api.entity.Role;
import com.employee.management.api.entity.User;
import com.employee.management.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);

        if (user == null)
            throw new UsernameNotFoundException("Could not find user");

        return new CustomUserDetails(user);
    }

    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Invalid UserName"));
    }

    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
