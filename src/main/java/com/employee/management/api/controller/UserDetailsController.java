package com.employee.management.api.controller;

import com.employee.management.api.entity.User;
import com.employee.management.api.service.UserDetailsServiceImplementation;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userDetailsServiceImplementation.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        userDetailsServiceImplementation.save(user);
        return user;
    }
}
