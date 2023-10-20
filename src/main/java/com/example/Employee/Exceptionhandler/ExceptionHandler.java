package com.example.Employee.Exceptionhandler;

import com.example.Employee.exception.EmailAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @org.springframework.web.bind.annotation.ExceptionHandler(EmailAlreadyExists.class)
    public String emailAlreadyExists(EmailAlreadyExists e){

        return e.getMessage();
    }



}
