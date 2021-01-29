package com.tdd.kata.stringcalculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    /**
     * TODO :-
     * link: https://osherove.com/tdd-kata-1
     *
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
        stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void return2() {
        stringCalculator = new StringCalculator();
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    void return3() {
        stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("3"));
    }

    @Test
    void return5() {
        stringCalculator = new StringCalculator();
        assertEquals(5, stringCalculator.add("2,3"));
        assertEquals(5, stringCalculator.add("3,2"));
    }


}