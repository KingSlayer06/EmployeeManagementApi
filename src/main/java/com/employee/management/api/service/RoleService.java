package com.employee.management.api.service;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    public Role findById(int id);

    public void save(Role role);

    public void deleteById(int id);

    public Role findByName(String name);
}
