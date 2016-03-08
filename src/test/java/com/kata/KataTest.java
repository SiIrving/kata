package com.kata;

import io.swagger.models.auth.In;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void stringContainsFourNumbersWithDifferentDelimitersIncludingSpecified_SplitIntoStringOfNumbersCalled_StringOfNumbersReturned() {
        Kata kata = new Kata();
        assertEquals(Arrays.asList("1","2","3","4"),kata.splitIntoStringOfNumbers("//;\n1\n2,3;4"));
    }

    private class Kata {

        private static final String OPTIONAL_DELIM_PATTERN = "//(.{1})\n";

        public int add(String s) {
            return s.isEmpty() ? 0 : Arrays.asList(s.split("[,\n]"))
                                        .stream()
                                        .mapToInt(String -> Integer.parseInt(String))
                                        .sum();
        }

        public List<String> splitIntoStringOfNumbers(String s) {
            Matcher matcher = Pattern.compile(OPTIONAL_DELIM_PATTERN + ".*")
                                    .matcher(s);
            String optionalDelim = "";
            if (matcher.find()) {
                optionalDelim = matcher.group(1);
                s = s.replaceAll(OPTIONAL_DELIM_PATTERN, "");
            }

            return Arrays.asList(s.split("[,\n" + optionalDelim + "]"));
        }
    }
}
