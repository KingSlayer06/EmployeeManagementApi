package com.employee.management.api.repository;

import com.employee.management.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT user from User user where user.username=?1")
    public User getUserByUsername(String username);
}
