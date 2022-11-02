package com.example.SpringCrudExample.model;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
@Column(name = "name")
    private String name;
@Column(name = "mobileno")
    private String mobileno;
@Column(name = "salary")
    private int salary;


    public Employee() {
    }

    public Employee(int id, String name, String mobileno, int salary)
    {
    this.id=id;
    this.name=name;
    this.mobileno=mobileno;
    this.salary=salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
