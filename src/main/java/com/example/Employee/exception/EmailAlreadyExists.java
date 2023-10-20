package com.example.Employee.exception;

public class EmailAlreadyExists extends Exception {

    public EmailAlreadyExists(String emailAlreadyExists, int i) {
       super(emailAlreadyExists+": "+i);

    }
}
