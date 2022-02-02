package com.jjh.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertThat("an empty string should return zero", result, equalTo(0));
  }

  @Test
  void testTwoSingleValueString() {
    int result = calc.add("1");
    assertThat("a string with 1 should return 1", result, equalTo(1));
  }

  @Test
  void testThreeTwoIntegerCommaSeparatedString() {
    int result = calc.add("1,2");
    assertThat("a string with 1, 2 should return 3", result, equalTo(3));
  }

  @Test
  void testFourThreeIntegerCommaSeparatedString() {
    int result = calc.add("1,2,3");
    assertThat("a string with 1,2,3  should return 6", result, equalTo(6));
  }

  @Test
  void testFiveTwoIntegerSemiColonSeparatedString() {
    int result = calc.add("1;2");
    assertThat("a string with 1;2  should return 3", result, equalTo(3));
  }

  @Test
  void testFiveTwoIntegerNewlineSeparatedString() {
    int result = calc.add("1\n2");
    assertThat("a string with 1\n2  should return 3", result, equalTo(3));
  }

  @Test
  void testFiveTwoMixedSeparatedString() {
    int result = calc.add("1\n2,3");
    assertThat("a string with 1\n2,3  should return 6", result, equalTo(6));
  }

  @Test
  void testFiveThreeMixedSeparatedString() {
    int result = calc.add("1,2\n3;4");
    assertThat("a string with 1,2\\n3;4 should return 10", result, equalTo(10));
  }

  @Test
  void testNineIncomepleteExpressionString() {
    assertThrows(ExpressionException.class, () -> {calc.add("1,");});
  }

  @Test
  void testTenNegativeNumberString() {
    assertThrows(NegativeNumberException.class, () -> {calc.add("1,-1");});
  }

  @Test
  void testElevenIgnoreNumberOverOneThousandString() {
    int result = calc.add("1001,2");
    assertThat("a string with 1001,2 should return 2", result, equalTo(2));
  }

  @Test
  void testTwelveLongerExpressionString() {
    int result = calc.add("1,2,3,4,5,6");
    assertThat("a string with 1, 2, 3, 4, 5, 6 should return 21", result, equalTo(21));
  }

}
