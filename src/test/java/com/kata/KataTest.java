package com.kata;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_AddCalled_ZeroReturned() {
        Kata kata = new Kata();
        assertEquals(0,kata.add(""));
    }


    private class Kata {
        public int add(String s) {
            return 0;
        }
    }
}
