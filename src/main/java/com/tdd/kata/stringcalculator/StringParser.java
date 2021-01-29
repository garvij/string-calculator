package com.tdd.kata.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private String delimiter;

    public StringParser() {
        delimiter = "[,\n]";
    }

    public List<Integer> parse(String numbers) {
        if (delimitersProvided(numbers)) {
            int startIndex = numbers.indexOf("//");
            int endIndex = numbers.lastIndexOf("\n");
            delimiter = numbers.substring(startIndex + 2, endIndex);
            numbers = numbers.substring(endIndex + 1);
        }
        return Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean delimitersProvided(String numbers) {
        return numbers.startsWith("//");
    }

}
