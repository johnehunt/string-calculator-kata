package com.jjh.calculator;

public class Calculator {
  public int add(String numbers) {
    int total = 0;
    if (numbers == null || numbers.equals("")) {
      return total;
    } else {
      if (numbers.endsWith(",") || numbers.endsWith(";") || numbers.endsWith("\n")) {
        throw new ExpressionException("Invalid Expression[%s]".formatted(numbers));
      }
      String[] values = numbers.split(",|;|\n");
      for (String value : values) {
        int num = Integer.parseInt(value.trim());
        if (num <0) {
          throw  new NegativeNumberException("Negative Number Found[%s]".formatted(num));
        } else if (num > 1000) {
          continue;
        }
        total += num;
      }
    }
    return total;
  }
}
