package com.example.test.model.advice;

import com.example.test.model.exception.StudyProgramNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudyProgramNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(StudyProgramNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String studyProgramNotFoundHandler(StudyProgramNotFoundException ex){
        return ex.getMessage();
    }

}
