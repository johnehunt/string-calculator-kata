package com.jjh.calculator;

public class Calculator {
  public int add(String numbers) {
    // Only do as much as is needed for the test
    int value = 0;
    if (!numbers.equals("")) {
      value = Integer.parseInt(numbers);
    }
    return value;
  }
}
