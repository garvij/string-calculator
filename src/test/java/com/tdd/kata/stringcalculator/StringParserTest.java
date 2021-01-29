package com.tdd.kata.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void before() {
        stringParser = new StringParser();
    }

    @Test
    void test_provided_delimiter_parsing() {
        assertEquals(Arrays.asList(5, 5), stringParser.parse("//;\n5;5"));
        assertEquals(Arrays.asList(2, 3, 5), stringParser.parse("//;\n2;3;5"));
        assertEquals(Arrays.asList(5, 5), stringParser.parse("//,\n5,5"));
        assertEquals(Arrays.asList(2, 3, 5), stringParser.parse("//,\n2,3,5"));
    }

    @Test
    void unlimited_delimiter_parsing() {
        assertEquals(Arrays.asList(1, 2, 3), stringParser.parse("//[***]\n1***2***3"));
    }


}