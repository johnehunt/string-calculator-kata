package com.jjh.calculator;

public class Calculator {
  public int add(String numbers) {
    int total = 0;
    if (numbers == null || numbers.equals("")) {
      return total;
    } else {
      String[] values = numbers.split(",");
      for (String value : values) {
        int num = Integer.parseInt(value);
        total += num;
      }
    }
    return total;
  }
}
