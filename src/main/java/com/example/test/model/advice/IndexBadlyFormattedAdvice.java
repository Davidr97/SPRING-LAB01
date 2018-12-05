package com.example.test.model.advice;

import com.example.test.model.exception.IndexBadlyFormattedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class IndexBadlyFormattedAdvice {

    @ResponseBody
    @ExceptionHandler(IndexBadlyFormattedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String indexBadlyFormattedHandler(IndexBadlyFormattedException ex){
        return ex.getMessage();
    }
}
