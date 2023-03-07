package com.logistic.test.cityservice.api.exceptions;

import com.logistic.test.cityservice.api.dtos.ExceptionResponse;
import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<ExceptionResponse> handleNotFoundException(EntityNotFoundException exception) {

    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(ExceptionResponse.builder()
            .message(exception.getMessage())
            .build());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionResponse> handleValidationException(
      MethodArgumentNotValidException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(ExceptionResponse.builder()
            .message(exception.getBindingResult().getFieldError().getDefaultMessage())
            .build());
  }
}
