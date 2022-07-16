package com.employee.management.api.service.implementation;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.repository.EmployeeRepository;
import com.employee.management.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee findById(int id) {
        return this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee Id: " + id + " not found !"));
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    public Employee findByEmail(String email) {
        return this.employeeRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Invalid email Address"));
    }

    @Transactional
    public List<Employee> findByFirstName(String firstName) {
        return this.employeeRepository.findByFirstName(firstName)
                .orElseThrow(() -> new IllegalArgumentException("Invalid FirstName"));
    }

    @Transactional
    public List<Employee> sortByFirstName(String sortOrder) {
        if (Objects.equals(sortOrder, "asc"))
            return employeeRepository.findAll(Sort.by("firstName").ascending());
        else
            return employeeRepository.findAll(Sort.by("firstName").descending());
    }
}
