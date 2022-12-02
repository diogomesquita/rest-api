package com.project.restapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionsController extends ResponseEntityExceptionHandler {
    @ResponseBody
    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<ErrorFormatter> notFoundExceptions(NotFoundExceptions e) {
        var message = new ErrorFormatter(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorFormatter(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }
    @ResponseBody
    @ExceptionHandler(DBexceptions.class)
    public ResponseEntity<ErrorFormatter> DBexceptions(DBexceptions e) {
        var message = new ErrorFormatter(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorFormatter(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }
}
