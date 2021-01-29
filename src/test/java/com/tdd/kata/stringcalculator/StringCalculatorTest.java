package com.tdd.kata.stringcalculator;


import com.tdd.kata.stringcalculator.exception.NegativeNumberArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void before() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void whenEmptyString_ShouldReturnZero() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void return_2() {
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    void return_3() {
        assertEquals(3, stringCalculator.add("3"));
    }

    @Test
    void return_5() {
        assertEquals(5, stringCalculator.add("2,3"));
        assertEquals(5, stringCalculator.add("3,2"));
    }

    @Test
    void return_7() {
        assertEquals(7, stringCalculator.add("2,3,2"));
        assertEquals(7, stringCalculator.add("3,2,2"));
    }

    @Test
    void return_9() {
        assertEquals(9, stringCalculator.add("1,2,3,3"));
        assertEquals(9, stringCalculator.add("3,2,3,1"));
    }

    @Test
    void return_6() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(6, stringCalculator.add("1,2\n3"));
        assertEquals(6, stringCalculator.add("1\n2\n3"));
        assertEquals(6, stringCalculator.add("3\n2\n1"));
        assertEquals(6, stringCalculator.add("3\n3"));
    }

    @Test
    void return_10() {
        assertEquals(10, stringCalculator.add("//;\n5;5"));
        assertEquals(10, stringCalculator.add("//;\n2;3;5"));
        assertEquals(10, stringCalculator.add("//,\n5,5"));
        assertEquals(10, stringCalculator.add("//,\n2,3,5"));
    }

    @Test
    void whenNegativeNumbers_shouldThrowException() {
        Exception exception = assertThrows(NegativeNumberArgumentException.class,
                () -> stringCalculator.add("//;\n5;-5"));
        System.out.println(exception.getMessage());
        assertEquals("Negative numbers not allowed: -5", exception.getMessage());
    }

    @Test
    void whenNumbersGreaterthan1000_theyShouldBeIgnored() {
        assertEquals(2, stringCalculator.add("2,1001"));
        assertEquals(3, stringCalculator.add("1001,2001,3"));
        assertEquals(1000, stringCalculator.add("1000,2000,3000"));
    }

    @Test
    void unlimitedDelimiterLength() {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    void multipleDelimiters() {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    void multipleDelimiters_and_unlimitedlength() {
        assertEquals(6, stringCalculator.add("//[**][%]\n1**2%3"));
        assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
    }

}