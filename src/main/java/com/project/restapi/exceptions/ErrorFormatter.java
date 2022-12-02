package com.project.restapi.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class ErrorFormatter implements Serializable {
    private static final long serialVersionUID = 1L;
    private Instant timestamp;
    private Integer status;
    private String message;

    public ErrorFormatter() {}

    public ErrorFormatter(Instant timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
