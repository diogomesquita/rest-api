package com.project.restapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionsController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundExceptions.class)
    public ResponseEntity<ErrorFormatter> notFoundExceptions(NotFoundExceptions e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorFormatter(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(DBexceptions.class)
    public ResponseEntity<ErrorFormatter> DBexceptions(DBexceptions e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorFormatter(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage()));
    }

}
