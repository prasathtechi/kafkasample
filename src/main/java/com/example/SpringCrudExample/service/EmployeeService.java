package com.example.SpringCrudExample.service;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.exception.EmployeeAlreadyExistsException;
import com.example.SpringCrudExample.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

   Employee getEmployeeDetails(int employeeId);

    Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException;

    Employee updateEmployee(int employeeId, Employee employee) throws DataNotFoundException;

    boolean deleteEmployee(int employeeId);
}
