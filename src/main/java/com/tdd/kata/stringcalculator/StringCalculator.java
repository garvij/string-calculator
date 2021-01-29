package com.tdd.kata.stringcalculator;

import com.tdd.kata.stringcalculator.exception.NegativeNumberArgumentException;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

    private final StringParser stringParser = new StringParser();

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        List<Integer> parsedNumbers = stringParser.parse(numbers);
        checkNegativeNumbers(parsedNumbers);
        return parsedNumbers
                .stream()
                .filter(number -> number <= 1000)
                .reduce(0, Integer::sum);
    }

    private void checkNegativeNumbers(List<Integer> numbers) {
        List<Integer> negativeNumbers = new LinkedList<>();
        for (Integer number : numbers) {
            if (number < 0) {
                negativeNumbers.add(number);
            }
        }
        if (!negativeNumbers.isEmpty()) {
            throw new NegativeNumberArgumentException(negativeNumbers);
        }
    }

}
