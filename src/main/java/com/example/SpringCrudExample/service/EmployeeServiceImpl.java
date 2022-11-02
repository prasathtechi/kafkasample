package com.example.SpringCrudExample.service;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.exception.EmployeeAlreadyExistsException;
import com.example.SpringCrudExample.model.Employee;
import com.example.SpringCrudExample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;
  /*  private static Map<Long, Employee> employees =new HashMap<>();
    private static Long index=2L;
    static {
        Employee employee1=new Employee(1L,"RAM","9578860240",10000);
        employees.put(1L,employee1);
        Employee employee2=new Employee(2L,"RAM babu","9578860243",1000);
        employees.put(2L,employee2);
    }*/

    public  List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }
public  Employee getEmployeeDetails(int employeeId )
{
    return  employeeRepository.findById(employeeId).get();
}
public  Employee addEmployee(Employee employee) throws EmployeeAlreadyExistsException {
    /*if(employee!=null)
    {
        return employeeRepository.save(employee);
    }
    else
        return null;*/


       return  employeeRepository.save(employee);



}
    public Employee updateEmployee(int employeeId, Employee employee) throws DataNotFoundException {
        try {
            Optional <Employee> emp = employeeRepository.findById(employeeId);
            if (emp.isPresent()) {
                Employee employee1 = emp.get();
                employee1.setName(employee.getName());
                employee1.setMobileno(employee.getMobileno());
                employee1.setSalary(employee.getSalary());
                employeeRepository.save(employee1);
                return employee1;
            }
            else {
                throw new DataNotFoundException("Employee not exists!!");
            }

        }
        catch (DataNotFoundException e)
        {

            throw new DataNotFoundException(e.getMessage());
        }

    }
    public  boolean deleteEmployee(int employeeId)
    {

    Employee employee = employeeRepository.findById(employeeId).get();
    if(employee!=null)
        employeeRepository.delete(employee);
    else
        return false;

    return true;
    }
}
