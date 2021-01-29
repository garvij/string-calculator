package com.tdd.kata.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    public int add(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        return Arrays.stream(numbers.split("[,\n]"))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

}
