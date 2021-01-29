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
            delimiter = getDelimiter(numbers);
            numbers = removeDelimiterLine(numbers);
        }
        return Arrays.stream(numbers.split(delimiter))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private String removeDelimiterLine(String numbers) {
        int delimiterStringEndIndex = numbers.indexOf("\n");
        return numbers.substring(delimiterStringEndIndex + 1);
    }

    private String getDelimiter(String numbers) {
        int delimiterStringEndIndex = numbers.indexOf("\n");
        if (numbers.contains("[")) {
            return Arrays.stream(numbers.substring(3, delimiterStringEndIndex - 1)
                    .split("]\\["))
                    .map(str -> "\\Q" + str + "\\E")
                    .collect(Collectors.joining("|"));
        }
        String unescapedDelimiterStr = numbers.substring(0, delimiterStringEndIndex)
                .replace("//", "")
                .replace("[", "")
                .replace("]", "");
        return "\\Q" + unescapedDelimiterStr + "\\E";
    }

    private boolean delimitersProvided(String numbers) {
        return numbers.startsWith("//");
    }

}
