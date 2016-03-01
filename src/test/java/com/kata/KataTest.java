package com.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void stringContainsThreeEntriesWithOneSpecifiedDelimiter_ParseInputCalled_ParsedInputReturned() {
        Kata.ParsedInput parsedInput = new Kata().parseInput("//;\n1;2,3");
        assertEquals(";", parsedInput.getOptionalDelim());
        assertEquals("1;2,3", parsedInput.getStringOfNumbers());
    }


    private class Kata {

        private String OPTIONAL_DELIM_PATTERN = "//(.{1})\\n";

        public int add(String s) {
            return s.isEmpty() ? 0 : Arrays.asList(s.split("[\n,]"))
                                        .stream()
                                        .mapToInt(String -> Integer.parseInt(String))
                                        .sum();
        }

        public ParsedInput parseInput(String s) {
            Matcher delimMatcher =
                    Pattern.compile(OPTIONAL_DELIM_PATTERN + ".*").matcher(s);

              String optionalDelim = delimMatcher.find() ? delimMatcher.group(1) : "";

            return new ParsedInput(optionalDelim, s.replaceAll(OPTIONAL_DELIM_PATTERN, ""));
        }

        public class ParsedInput {

            private String optionalDelim;

            private String stringOfNumbers;

            ParsedInput(String optionalDelim, String stringOfNumbers) {
                this.optionalDelim = optionalDelim;
                this.stringOfNumbers = stringOfNumbers;
            }

            public String getOptionalDelim() {
                return optionalDelim;
            }

            public String getStringOfNumbers() {
                return stringOfNumbers;
            }
        }
    }
}
