package com.example.SpringCrudExample.exception;



public class EmployeeAlreadyExistsException extends Throwable {
    private String message;

    public EmployeeAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;

    }
}
