package com.example.test.model.exception;

public class IndexBadlyFormattedException extends RuntimeException {

    public IndexBadlyFormattedException(String index)
    {
        super(String.format("The index %s should be 6-digit number", index));
    }
}
