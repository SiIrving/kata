package com.kata;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KataTest {

    @Test
    public void stringIsEmpty_addCalled_ZeroReturned() {
        assertEquals(0, new Kata().add(""));
    }


    private class Kata {
        public int add(String s) {
            return 0;
        }
    }
}
