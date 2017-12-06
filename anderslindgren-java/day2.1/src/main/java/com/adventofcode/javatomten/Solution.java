package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Advent of Code 2017-12-02.
 */
public class Solution {

    public static void main(String... args) throws IOException {
        Solution solution = new Solution();
        List<String> input = solution.parseArgs(args);
        int sum = solution.parse(input);
        System.out.println(sum);
    }

    private List<String> parseArgs(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("expected arguments: <input file name>");
            System.exit(1);
        }
        Path path = FileSystems.getDefault().getPath(args[0]);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader.lines()
                     .collect(Collectors.toList());
    }

    int parse(List<String> input) {
        return input.stream()
                    .mapToInt(this::getHighestLowestDiff)
                    .sum();
    }

    private int getHighestLowestDiff(String input) {
        final String[] numbers = input.split("\\W");
        IntSummaryStatistics stats = Arrays.stream(numbers)
                                           .mapToInt(Integer::parseInt)
                                           .boxed()
                                           .collect(Collectors.summarizingInt(Integer::intValue));

        final int lowest = stats.getMin();
        final int highest = stats.getMax();
        return highest - lowest;
    }

}
