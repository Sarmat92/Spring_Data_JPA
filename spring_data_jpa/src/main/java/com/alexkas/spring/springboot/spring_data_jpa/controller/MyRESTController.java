package com.alexkas.spring.springboot.spring_data_jpa.controller;


import com.alexkas.spring.springboot.spring_data_jpa.entity.Employee;
import com.alexkas.spring.springboot.spring_data_jpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> showAllEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }

    @PostMapping("/employee")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        employeeService.deleteEmployeeById(id);
        return "Employee with ID = " + id + " was deleted.";
    }

    @GetMapping("/employee/name/{name}")
    public List<Employee> showAllEmployeesByName(@PathVariable String name) {
        List<Employee> employeeList = employeeService.findAllByName(name);
        return employeeList;
    }
}
