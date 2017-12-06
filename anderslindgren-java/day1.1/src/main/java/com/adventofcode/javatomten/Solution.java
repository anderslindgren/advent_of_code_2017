package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.getProperty;

/**
 * Advent of Code 2017-12-01.
 */
public class Solution {

    public static void main(String... args) throws IOException {
        Solution solution = new Solution();
        List<String> input = solution.parseArgs(args);
        int[] numbers = solution.toIntArray(input.get(0));
        int sum = solution.parse(numbers);
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

    int[] toIntArray(String input) {
        int[] result = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = parseInt(Character.toString(input.charAt(i)));
        }
        return result;
    }

    int parse(int[] ints) {
        int result = 0;
        final int last = ints.length - 1;
        for (int i = 0; i < last; i++) {
            if (ints[i] == ints[i + 1]) {
                result += ints[i];
            }
        }
        if (ints[last] == ints[0]) {
            result += ints[last];
        }
        return result;
    }

}
