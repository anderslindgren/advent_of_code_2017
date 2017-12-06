package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.lang.System.getProperty;

/**
 * Advent of Code 2017-12-02.
 */
public class Solution {

    public static void main(String... args) throws IOException {
        Solution solution = new Solution();
        List<String> input = solution.parseArgs(args);
        int sum = solution.parse(input);
        final String dir = getProperty("user.dir");
        System.out.println(format("%s: %d", dir.substring(dir.lastIndexOf("/") + 1), sum));
    }

    private List<String> parseArgs(String[] args) throws IOException {
        String file = "input.txt";
        if (args.length == 1) {
            file = args[0];
        }
        Path path = FileSystems.getDefault().getPath(file);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader.lines()
                     .collect(Collectors.toList());
    }

    int parse(List<String> input) {
        return input.stream()
                    .mapToInt(this::getDividenceBetweenEvenDividable)
                    .sum();
    }

    private int getDividenceBetweenEvenDividable(String input) {
        final String[] numbers = input.split("\\W");
        final int[] ints = Arrays.stream(numbers)
                                 .mapToInt(Integer::parseInt)
                                 .toArray();

        int a = 0;
        int b = 0;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i != j && ints[i] % ints[j] == 0) {
                    a = ints[i];
                    b = ints[j];
                    break;
                }
            }
        }

        return Math.max(a, b) / Math.min(a, b);
    }

}
