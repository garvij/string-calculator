package com.tdd.kata.stringcalculator;


import com.tdd.kata.stringcalculator.exception.NegativeNumberArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    /**
     * link: https://osherove.com/tdd-kata-1
     * <p>
     * The method can take up to two numbers, separated by commas, and will return their sum.
     * for example “” or “1” or “1,2” as inputs.
     * (for an empty string it will return 0)
     * Hints:
     * ——————
     * - Start with the simplest test case of an empty string and move to one and two numbers
     * - Remember to solve things as simply as possible so that you force yourself
     * to write tests you did not think about
     * - Remember to refactor after each passing test
     */

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

    /**
     * Allow the Add method to handle an unknown amount of numbers
     */

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

    /**
     * Allow the Add method to handle new lines between numbers (instead of commas).
     * the following input is ok: “1\n2,3” (will equal 6)
     * the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)
     */

    @Test
    void return_6() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
        assertEquals(6, stringCalculator.add("1,2\n3"));
        assertEquals(6, stringCalculator.add("1\n2\n3"));
        assertEquals(6, stringCalculator.add("3\n2\n1"));
        assertEquals(6, stringCalculator.add("3\n3"));
    }

    /**
     * Support different delimiters
     * to change a delimiter, the beginning of the string will contain a separate line
     * that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2”
     * should return three where the default delimiter is ‘;’ .
     * the first line is optional. all existing scenarios should still be supported
     */
    @Test
    void return_10() {
        assertEquals(10, stringCalculator.add("//;\n5;5"));
        assertEquals(10, stringCalculator.add("//;\n2;3;5"));
        assertEquals(10, stringCalculator.add("//,\n5,5"));
        assertEquals(10, stringCalculator.add("//,\n2,3,5"));
    }

    /**
     * Calling Add with a negative number will throw an exception “negatives not allowed” -
     * and the negative that was passed.
     * if there are multiple negatives, show all of them in the exception message.
     */
    @Test
    void whenNegativeNumbers_shouldThrowException() {
        Exception exception = assertThrows(NegativeNumberArgumentException.class,
                () -> stringCalculator.add("//;\n5;-5"));
        System.out.println(exception.getMessage());
        assertEquals("Negative numbers not allowed: -5", exception.getMessage());
    }

    /**
     * Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
     */
    @Test
    void whenNumbersGreaterthan1000_theyShouldBeIgnored() {
        assertEquals(2, stringCalculator.add("2,1001"));
        assertEquals(3, stringCalculator.add("1001,2001,3"));
        assertEquals(1000, stringCalculator.add("1000,2000,3000"));
    }

    /**
     * Delimiters can be of any length with the following
     * format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
     */
    @Test
    void unlimitedDelimiterLength() {
        assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
    }

    /**
     * Allow multiple delimiters like this: “//[delim1][delim2]\n”
     * for example “//[*][%]\n1*2%3” should return 6.
     */
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