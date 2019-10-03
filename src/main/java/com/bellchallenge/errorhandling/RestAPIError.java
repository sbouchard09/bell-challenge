package com.bellchallenge.errorhandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Basic REST error handling
 * inspired by: https://www.toptal.com/java/spring-boot-rest-api-error-handling
 */
public class RestAPIError {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private HttpStatus status;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors; // holds an array of sub-errors that happened

    public RestAPIError(HttpStatus status) {
        this.status = status;
    }

    public RestAPIError(HttpStatus status, Throwable e) {
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = e.getLocalizedMessage();
    }

    public RestAPIError(HttpStatus status, String message, Throwable e) {
        this.status = status;
        this.message = message;
        this.debugMessage = e.getLocalizedMessage();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }
}
