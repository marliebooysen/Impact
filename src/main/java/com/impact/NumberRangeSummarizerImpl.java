package com.impact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(final String input) {

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must have a value");
        }

        List<Integer> inputList = new ArrayList<>();
        for (String number : input.split(",")) {
            inputList.add(Integer.parseInt(number.trim()));
        }
        return inputList;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        // To avoid null pointer
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input must have a value");
        }

        final Integer[] numberArray = input.toArray(new Integer[0]);
        Arrays.sort(numberArray);

        // Initializing
        int length = numberArray.length;
        int startRange = 0;
        int endRange = 0;
        StringBuilder summary = new StringBuilder();

        // Loop through numberArray and build String
        while (startRange < length) {
            while (++endRange < length && (numberArray[endRange] - numberArray[endRange - 1]) == 1) ; // false
            if (endRange - startRange > 2) {
                summary.append(numberArray[startRange]).append("-").append(numberArray[endRange - 1]).append(", ");
                startRange = endRange;
            } else {
                for (; startRange < endRange; startRange++) {
                    summary.append(numberArray[startRange]).append(", ");
                }
            }
        }

        // Remove trailing comma
        String summarisedString = summary.toString();
        summarisedString = summarisedString.substring(0, summarisedString.lastIndexOf(','));

        return summarisedString;
    }
}