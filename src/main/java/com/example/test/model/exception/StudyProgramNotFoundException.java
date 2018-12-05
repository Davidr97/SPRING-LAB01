package com.example.test.model.exception;

public class StudyProgramNotFoundException extends RuntimeException {

    public StudyProgramNotFoundException(String id){
        super("Could not find study program " + id);
    }
}
