package com.company;

public class MyExceptionHandler extends RuntimeException{
    public MyExceptionHandler(String message) {
        super(message);
    }
}
