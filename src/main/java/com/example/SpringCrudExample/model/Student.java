package com.example.SpringCrudExample.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="student")
public class Student
{
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
  @Id
   @Column(name="rollno")
    private int rollno;


    @Column(name="name")
    private String name;

    @Column(name="dob")
    private LocalDate dob;
    @Column(name="address")
    private String address;

    public Student() {
    }

    public Student(int rollno,String name, LocalDate dob, String address)
    {
        this.rollno=rollno;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
