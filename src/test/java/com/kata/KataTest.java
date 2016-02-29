package com.kata;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_addCalled_ZeroReturned() {
        assertEquals(0, new Kata().add(""));
    }

    @Test
    public void stringContainsOneNumber_addCalled_NumberReturned() {
        assertEquals(1, new Kata().add("1"));
    }

    @Test
    public void stringContainsTwoNumbers_addCalled_SumOfTwoNumbersReturned() {
        assertEquals(3, new Kata().add("1,2"));
    }

    @Test
    public void stringContainsThreeNumbers_addCalled_SumOfThreeNumbersReturned() {
        assertEquals(6, new Kata().add("1,2,3"));
    }


    private class Kata {
        public int add(String s) {
            return s.isEmpty() ? 0 : Arrays.asList(s.split(","))
                                            .stream()
                                            .mapToInt(String -> Integer.parseInt(String))
                                            .sum();
        }
    }
}
