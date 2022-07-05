package com.employee.management.api.service;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee Id: " + id + " not found !"));
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findByEmail(String email) {
        return this.employeeRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email Address"));
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return this.employeeRepository.findByFirstName(firstName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid FirstName"));
    }
}
