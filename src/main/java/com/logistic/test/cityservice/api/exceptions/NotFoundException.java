package com.logistic.test.cityservice.api.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotFoundException extends RuntimeException {

  HttpStatus status;

  public NotFoundException(String message, HttpStatus status) {
    super(message);
    this.status = status;
  }
}
