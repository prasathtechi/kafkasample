package com.example.SpringCrudExample.exception;

public class DataNotFoundException extends Throwable{
    private String message;
    public DataNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;

    }
}
