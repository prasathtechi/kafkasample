package com.example.SpringCrudExample.service;

import com.example.SpringCrudExample.exception.DataNotFoundException;
import com.example.SpringCrudExample.model.Student;
import com.example.SpringCrudExample.repository.StudentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{
@Autowired
private StudentRepositary studentRepositary;
    @Override
    public List<Student> getAllStudents() {
        return studentRepositary.findAll();
    }

    @Override
    public Student getStudentDetails(int rollno) throws DataNotFoundException {
               try {


            Optional<Student> studentOptional = studentRepositary.findById(rollno);
            if (studentOptional.isPresent()) {

                return studentRepositary.findById(rollno).get();
            } else
            {
                throw new DataNotFoundException("Student not exists!!");
            }

        }
        catch (DataNotFoundException e)
        {

            throw new DataNotFoundException(e.getMessage());
        }
    }

    @Override
    public Student addStudent(Student student)
    {

       return studentRepositary.save(student);
   }


    @Override
    public Student updateStudent(int rollno, Student student) throws DataNotFoundException {
        try {
            Optional<Student>stu=studentRepositary.findById(rollno);
            if(stu.isPresent())
            {
                Student student1=stu.get();
                student1.setName(student.getName());
               student1.setDob(student.getDob());
                student1.setAddress(student.getAddress());
                studentRepositary.save(student1);
                return student1;
            }else
            {
                throw new DataNotFoundException("Student not exists!!");
            }

        }
        catch (DataNotFoundException e)
        {

            throw new DataNotFoundException(e.getMessage());
        }
        }


    @Override
    public Student deleteStudent(int rollno) throws DataNotFoundException {

        try {


            Optional<Student> studentOptional = studentRepositary.findById(rollno);
            if (studentOptional.isPresent()) {
                studentRepositary.deleteById(rollno);
                return null;
            } else
        {
            throw new DataNotFoundException("Student not exists!!");
        }

    }
        catch (DataNotFoundException e)
    {

        throw new DataNotFoundException(e.getMessage());
    }


    }
}
