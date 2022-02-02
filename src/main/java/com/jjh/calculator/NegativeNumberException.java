package com.jjh.calculator;

public class NegativeNumberException extends RuntimeException {
  public NegativeNumberException(String message) {
    super(message);
  }

  public NegativeNumberException(String message, Throwable cause) {
    super(message, cause);
  }
}
