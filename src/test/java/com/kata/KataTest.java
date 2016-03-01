package com.kata;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_AddCalled_ZeroReturned() {
        assertEquals(0, new Kata().add(""));
    }

    @Test
    public void stringContainsOneEntry_AddCalled_EntryReturned() {
        assertEquals(1, new Kata().add("1"));
    }

    @Test
    public void stringContainsTwoEntries_AddCalled_SumOfEntriesReturned() {
        assertEquals(3, new Kata().add("1,2"));
    }

    @Test
    public void stringContainsThreeEntries_AddCalled_SumOfEntriesReturned() {
        assertEquals(6, new Kata().add("1,2,3"));
    }

    @Test
    public void stringContainsThreeEntriesWithDifferentDelimiters_AddCalled_SumOfEntriesReturned() {
        assertEquals(6, new Kata().add("1\n2,3"));
    }

    @Test
    public void stringContainsThreeEntriesWithOneSpecifiedDelimiter_AddCalled_SumOfEntriesReturned() {
        assertEquals(6, new Kata().add("//;\n1;2,3"));
    }


    private class Kata {

        public int add(String s) {
            return s.isEmpty() ? 0 : Arrays.asList(s.split("[\n,]"))
                                        .stream()
                                        .mapToInt(String -> Integer.parseInt(String))
                                        .sum();
        }
    }
}
