package com.example.SpringCrudExample.service;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.model.Student;

import java.util.List;


public interface StudentService
{
    List<Student>getAllStudents();
    Student getStudentDetails(int rollno) throws DataNotFoundException;
    Student addStudent(Student student);
    Student updateStudent(int rollno,Student student) throws DataNotFoundException;
    Student deleteStudent(int rollno) throws DataNotFoundException;
}
