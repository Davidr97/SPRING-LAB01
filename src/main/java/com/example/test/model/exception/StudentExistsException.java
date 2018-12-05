package com.example.test.model.exception;

public class StudentExistsException extends RuntimeException {

    public StudentExistsException(Long index){
        super(String.format("Student with id %d already exists.", index));
    }
}
