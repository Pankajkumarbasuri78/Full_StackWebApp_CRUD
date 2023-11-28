package com.springreact.studentdashboard.exception;

public class StudentAlreadyExistsException extends RuntimeException{

    public StudentAlreadyExistsException(String message) {
        super(message);
    }

}
