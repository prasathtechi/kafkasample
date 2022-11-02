package com.example.SpringCrudExample.controller;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.exception.EmployeeAlreadyExistsException;
import com.example.SpringCrudExample.model.Employee;
import com.example.SpringCrudExample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId)
    {
        return employeeService.getEmployeeDetails(employeeId);
    }
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        try {
            return employeeService.addEmployee(employee);
        } catch (EmployeeAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/updateEmployee/{employeeId}")
    public Employee updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) throws DataNotFoundException {

        return employeeService.updateEmployee(employeeId,employee);
    }
    @DeleteMapping("/deleteEmployee/{employeeId}")
    public boolean deleteEmployee(@PathVariable int employeeId)
    {
        return employeeService.deleteEmployee(employeeId);
    }
}
