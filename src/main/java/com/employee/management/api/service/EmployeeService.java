package com.employee.management.api.service;

import com.employee.management.api.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

    public Employee findByEmail(String email);

    public Employee findByFirstName(String firstName);
}
