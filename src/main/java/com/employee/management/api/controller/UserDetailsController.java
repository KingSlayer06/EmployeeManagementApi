package com.employee.management.api.controller;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.entity.Role;
import com.employee.management.api.entity.User;
import com.employee.management.api.service.RoleService;
import com.employee.management.api.service.implementation.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserDetailsController {

    @Autowired
    private UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    private RoleService roleService;

    @GetMapping("/listUsers")
    public List<User> getAllUsers() {
        return userDetailsServiceImplementation.findAll();
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userDetailsServiceImplementation.save(user);
        return user;
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        User user1 = userDetailsServiceImplementation.findByUsername(user.getUsername());

        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setRoles(user.getRoles());

        userDetailsServiceImplementation.save(user1);
        return user1;
    }

    @DeleteMapping("/deleteUser/{username}")
    public void deleteUser(@PathVariable String username) {
        User user = userDetailsServiceImplementation.findByUsername(username);

        if (user == null)
            throw new RuntimeException("UserName: " + username + " not found");
        userDetailsServiceImplementation.deleteById(user.getId());
        System.out.println("Deleted employee - " + username);
    }
}
