package com.leetcode.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleCustomException(InvalidInputException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
