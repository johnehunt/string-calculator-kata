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
}
