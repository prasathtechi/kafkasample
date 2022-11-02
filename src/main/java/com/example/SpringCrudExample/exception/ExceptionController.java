package com.example.SpringCrudExample.exception;

import com.example.SpringCrudExample.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value=DataNotFoundException.class)
    public ResponseEntity<Object> exception(DataNotFoundException exception)
    {
        ErrorResponse er=new ErrorResponse();
        er.setStausCode(HttpStatus.NOT_FOUND.toString());
        er.setErrorMsg(exception.getMessage());
        return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);
    }

}
