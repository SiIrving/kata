package com.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void inputStringIsEmpty_addCalled_ZeroReturned() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    public void inputStringContainsOneNumber_addCalled_NumberReturned() {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    public void inputStringContainsTwoNumbers_addCalled_SumOfNumbersReturned() {
        assertEquals(3, new StringCalculator().add("1,2"));
    }

    @Test
    public void inputStringContainsThreeNumbers_addCalled_SumOfNumbersReturned() {
        assertEquals(6, new StringCalculator().add("1,2,3"));
    }

    @Test
    public void inputStringContainsThreeNumbersWithNewLineAndCommaDelimeters_addCalled_SumOfNumbersReturned() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    @Test
    public void inputStringContainsThreeNumbersWithSpecifiedDelimeter_addCalled_SumOfNumbersReturned() {
        assertEquals(2, new StringCalculator().add("//;\n1;2"));
    }
    
    public class StringCalculator {

        private static final String OPTIONAL_DELIMITER_PATTERN
                = "(//(.{1})\n)";

        public int add(String numbers) {
            return numbers.isEmpty() ? 0
                    : sumStringOfNumbers(numbers);
        }

        private int sumStringOfNumbers(String numbers) {

            Matcher optionalDelimiterMatcher = Pattern
                        .compile(OPTIONAL_DELIMITER_PATTERN)
                        .matcher(numbers);

            String optionalDelimiter = "";
            if (optionalDelimiterMatcher.matches()) {
                optionalDelimiter = optionalDelimiterMatcher.group();
            }

            return Arrays.asList(numbers.split("[,\n" + optionalDelimiter + "]"))
                      .stream()
                      .mapToInt(String -> Integer.parseInt(String))
                      .sum();
        }
    }


}
