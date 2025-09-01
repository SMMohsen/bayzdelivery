package com.bayzdelivery.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ResponseStatus
  @ExceptionHandler
  public ErrorDTO handle(Exception exception) {
    LOG.error("Request could not be processed: ", exception);
    return new ErrorDTO(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(CustomException.class)
  public ErrorDTO handleResourceNotFoundException(CustomException customException) {

    return new ErrorDTO(customException.getMessage());
  }
}
