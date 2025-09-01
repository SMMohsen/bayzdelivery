package com.bayzdelivery.exceptions;

public class PersonAlreadyExistsException extends CustomException {
  public PersonAlreadyExistsException(String message) {
    super(message);
  }
}
