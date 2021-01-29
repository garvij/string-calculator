package com.tdd.kata.stringcalculator.exception;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNumberArgumentException extends RuntimeException {

    public NegativeNumberArgumentException(List<Integer> negativeNumbers) {
        super("Negative numbers not allowed: " +
                negativeNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(",")));
    }

}
