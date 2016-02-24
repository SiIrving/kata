package com.kata;

import org.junit.Test;

import java.util.Optional;
import java.util.regex.Pattern;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_addNumbersInStringCalled_ResultIsZero() {
        assertEquals(0, new StringCalculator().addNumbersInString(""));
    }

    @Test
    public void stringContainsOneNumber_addNumbersInStringCalled_ResultIsThatNumber() {
        assertEquals(1, new StringCalculator().addNumbersInString("1"));
    }

    @Test
    public void stringContainsTwoNumbers_addNumbersInStringCalled_ResultIsSumOfThoseNumbers() {
        assertEquals(3, new StringCalculator().addNumbersInString("1,2"));
    }

    @Test
    public void stringContainsThreeNumbers_addNumbersInStringCalled_ResultIsSumOfThoseNumbers() {
        assertEquals(6, new StringCalculator().addNumbersInString("1,2,3"));
    }

    @Test
    public void stringContainsThreeNumbersWithMixedDelimeters_addNumbersInStringCalled_ResultIsSumOfThoseNumbers() {
        assertEquals(6, new StringCalculator().addNumbersInString("1,2\n3"));
    }

    @Test
    public void stringContainsFourNumbersWithANewDelimeter_addNumbersInStringCalled_ResultIsSumOfThoseNumbers() {
        assertEquals(10, new StringCalculator().addNumbersInString("//;\n1,2\n3;4"));
    }

    public class StringCalculator {

        public int addNumbersInString(String input) {
            return input.isEmpty() ?
                        0 : sumNumbersInString(input);
        }

        private int sumNumbersInString(String input) {
            int sum = 0;
            for (String numberAsString : input.split("[,\n]")) {
                sum = sum + new Integer(numberAsString);
            }
            return sum;
        }

        private Optional<String> findOptionalNewLimiter(String input) {
            Pattern matchOptionalNewDelimiter = Pattern.compile("(//.{1}).*");
            return Optional.empty();
        }

    }

}
