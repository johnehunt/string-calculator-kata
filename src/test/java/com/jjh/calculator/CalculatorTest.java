package com.jjh.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CalculatorTest {

  private Calculator calc;

  @BeforeEach
  void setUp() {
    calc = new Calculator();
  }

  @AfterEach
  void tearDown() {
    calc = null;
  }

  @Test
  void testOneEmptyString() {
    int result = calc.add("");
    assertThat("an empty string should return zero", 0, equalTo(result));
  }
}
