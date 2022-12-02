package com.project.restapi.exceptions;

public class NotFoundExceptions extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public NotFoundExceptions(Object obj) {
        super(String.format("404 Not Found - Id: " + obj));
    }
}
