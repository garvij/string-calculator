package com.tdd.kata.stringcalculator;

public class StringCalculator {

    private final StringParser stringParser = new StringParser();

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return stringParser.parse(numbers)
                .stream()
                .reduce(0, Integer::sum);
    }

}
