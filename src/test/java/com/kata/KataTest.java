package com.kata;

import org.junit.Test;

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

    private class Kata {
        public int add(String s) {
            return s.isEmpty() ? 0 : Integer.parseInt(s);
        }
    }
}
