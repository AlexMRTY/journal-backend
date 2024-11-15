package com.asifshirvan.journal_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerErrorException;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {PatientAlreadyExistsException.class})
    public ResponseEntity<Object> handleException(PatientAlreadyExistsException e) {
        HttpStatus status = HttpStatus.CONFLICT;
        return buildResponseEntity(e, status);
    }

    @ExceptionHandler(value = {PatientNotFoundException.class})
    public ResponseEntity<Object> handlePatientNotFoundException(PatientNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        return buildResponseEntity(e, status);
    }

    private ResponseEntity<Object> buildResponseEntity(RuntimeException e, HttpStatus status) {
        ApiException apiException = new ApiException(
                e.getMessage(),
                status,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        return new ResponseEntity<>(apiException, status);
    }

    @ExceptionHandler(value = {JpaException.class})
    public ResponseEntity<Object> handleJpaException(JpaException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return buildResponseEntity(e, status);
    }

    @ExceptionHandler(value = {ServerErrorException.class})
    public ResponseEntity<Object> handleServerErrorException(ServerErrorException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        return buildResponseEntity(e, status);
    }
}
