package com.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_addNumbersCalled_ZeroReturned() {
        assertEquals(0, new StringCalculator().addNumbers(""));
    }

    @Test
    public void stringContainsOneNumber_addNumbersCalled_NumberIsReturned() {
        assertEquals(1, new StringCalculator().addNumbers("1"));
    }

    @Test
    public void stringContainsTwoNumbers_addNumbersCalled_NumberIsReturned() {
        assertEquals(3, new StringCalculator().addNumbers("1,2"));
    }

    private class StringCalculator {

        public int addNumbers(String input) {
            return input.isEmpty()
                        ? 0 : sumListOfInts(Arrays.asList(input.split(","))
                                    .stream()
                                    .map(NumberAsString
                                            -> new Integer(NumberAsString))
                                    .collect(Collectors.toList()));
        }

        private int sumListOfInts(List<Integer> collect) {
            int sum = 0;
            for (Integer integer : collect) {
                sum = sum + integer;
            }
            return sum;
        }

    }
}
