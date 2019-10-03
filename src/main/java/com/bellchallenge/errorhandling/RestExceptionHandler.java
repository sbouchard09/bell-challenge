package com.bellchallenge.errorhandling;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Adds exception handlers for custom exceptions (i.e. CartNotFoundException & ProductNotFoundException) and for
 * the NullPointerException and the EntityNotFoundException
 * inspired by: https://www.toptal.com/java/spring-boot-rest-api-error-handling
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Exception handler for CartNotFoundExceptions
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CartNotFoundException.class)
    protected ResponseEntity<Object> handleCartNotFound(CartNotFoundException e) {
        RestAPIError error = new RestAPIError(NOT_FOUND);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

    /**
     * Exception handler for ProductNotFoundExceptions
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ProductNotFoundException.class)
    protected ResponseEntity<Object> handleProductNotFound(ProductNotFoundException e) {
        RestAPIError error = new RestAPIError(NOT_FOUND);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

    /**
     * Exception handler for NullPointerException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<Object> handleNullPointer(NullPointerException e) {
        RestAPIError error = new RestAPIError(NOT_FOUND);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

    /**
     * Exception handler for EntityNotFoundException
     *
     * @param e
     * @return
     */
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException e) {
        RestAPIError error = new RestAPIError(NOT_FOUND);
        error.setMessage(e.getMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }
}
