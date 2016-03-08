package com.kata;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_AddCalled_ZeroReturned() {
        Kata kata = new Kata();
        assertEquals(0,kata.add(""));
    }

    @Test
    public void stringContainsNumber_AddCalled_NumberReturned() {
        Kata kata = new Kata();
        assertEquals(1,kata.add("1"));
    }

    @Test
    public void stringContainsTwoNumbers_AddCalled_SumReturned() {
        Kata kata = new Kata();
        assertEquals(3,kata.add("1,2"));
    }

    @Test
    public void stringContainsThreeNumbers_AddCalled_SumReturned() {
        Kata kata = new Kata();
        assertEquals(6,kata.add("1,2,3"));
    }

    @Test
    public void stringContainsThreeNumbersWithDifferentDelimiters_AddCalled_SumReturned() {
        Kata kata = new Kata();
        assertEquals(6,kata.add("1\n2,3"));
    }

    private class Kata {
        public int add(String s) {
            return s.isEmpty() ? 0 : Arrays.asList(s.split("[,\n]"))
                                        .stream()
                                        .mapToInt(String -> Integer.parseInt(String))
                                        .sum();
        }
    }
}
