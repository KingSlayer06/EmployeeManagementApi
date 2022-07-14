package com.employee.management.api.controller;

import com.employee.management.api.entity.Employee;
import com.employee.management.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeManagementController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee Id: " + employeeId + " not found");
        return employee;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/addEmployee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/updateEmployee")
    @ResponseStatus(HttpStatus.PROCESSING)
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.findById(employee.getId());

        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());

        employeeService.save(employee1);
        return employee1;
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if (employee == null)
            throw new RuntimeException("Employee Id: " + employeeId + " not found");
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

    @GetMapping("/employees/search/{firstName}")
    public Employee findByFirstName(@PathVariable String firstName) {
        Employee employee = employeeService.findByFirstName(firstName);

        if (employee == null)
            throw new RuntimeException("Employee Name: " + firstName + " not found");
        return employee;
    }
}
