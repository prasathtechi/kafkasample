package com.example.SpringCrudExample.controller;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.model.Student;
import com.example.SpringCrudExample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();

    }
    @GetMapping("/student/{rollno}")
    public Student getStudentDetails(@PathVariable int rollno) throws DataNotFoundException {
        return studentService.getStudentDetails(rollno);
    }
    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        System.out.println("Add Student");
        return studentService.addStudent(student);
    }
    @PutMapping("/updateStudent/{rollno}")
    public Student updateStudent(@PathVariable int rollno,@RequestBody Student student)throws DataNotFoundException
    {
        System.out.println("update Student");
        return studentService.updateStudent(rollno,student);
    }
    @DeleteMapping("/deleteStudent/{rollno}")
    public Student deleteStudent(@PathVariable int rollno) throws DataNotFoundException
    {
        System.out.println("try to delete");
        return studentService.deleteStudent(rollno);

    }
}
