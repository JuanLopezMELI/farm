package com.farmers.farm.exceptions;

public class AnimalNotFoundException extends RuntimeException {

  public AnimalNotFoundException(String message) {
    super(message);
  }
}
