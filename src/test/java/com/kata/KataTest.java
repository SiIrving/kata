package com.kata;

import org.junit.Test;

import java.util.Arrays;

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
        public int add(String numbers) {
            return numbers.isEmpty() ? 0
                    : sumStringOfNumbers(numbers);
        }
    }

    private int sumStringOfNumbers(String numbers) {
        return Arrays.asList(numbers.split("[,\n]"))
                .stream()
                .mapToInt(String -> Integer.parseInt(String))
                .sum();
    }


}
