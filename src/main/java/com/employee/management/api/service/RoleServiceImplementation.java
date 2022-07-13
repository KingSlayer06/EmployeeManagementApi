package com.employee.management.api.service;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.entity.Role;
import com.employee.management.api.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImplementation implements RoleService {

    private RolesRepository rolesRepository;

    @Autowired
    public RoleServiceImplementation(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public List<Role> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        return this.rolesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Role Id: " + id + " not found !"));
    }

    @Override
    public void save(Role role) {
        rolesRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        rolesRepository.deleteById(id);
    }

    @Override
    public Role findByName(String name) {
        return this.rolesRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Role Name"));
    }
}
