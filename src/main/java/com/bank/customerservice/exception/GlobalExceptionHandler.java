package com.bank.customerservice.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //TODO
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class, NullPointerException.class})
    public Object test(Exception e){
        return "error response";
    }
}
