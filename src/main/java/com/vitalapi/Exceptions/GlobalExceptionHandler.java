package com.vitalapi.Exceptions;

import com.vitalapi.Exceptions.Class.IlegalActionException;
import com.vitalapi.Exceptions.Class.ResourceDuplicateException;
import com.vitalapi.Exceptions.Class.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourseNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMensaje(),
                request.getDescription(false),
                "NOT FOUND"
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceDuplicateException.class)
    public ResponseEntity<ErrorDetails> handleResourceDuplicateException(ResourceDuplicateException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMensaje(),
                request.getDescription(false),
                "DUPLICATE"
        );
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IlegalActionException.class)
    public ResponseEntity<ErrorDetails> handleIllegalActionException(IlegalActionException ex, WebRequest request) {
        ErrorDetails error = new ErrorDetails(
                LocalDateTime.now(),
                ex.getMensaje(),
                request.getDescription(false),
                "ILLEGAL"
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
