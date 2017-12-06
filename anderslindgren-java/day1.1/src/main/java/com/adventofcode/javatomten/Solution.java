package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

/**
 * Advent of Code 2017-12-01.
 */
public class Solution {

    public static void main(String... args) throws IOException {
        Solution solution = new Solution();
        List<String> input = solution.parseArgs(args);
        int[] numbers = solution.toIntArray(input.get(0));
        int sum = solution.parse(numbers);
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

    int[] toIntArray(String input) {
        int[] result = new int[input.length()];
        for (int i = 0 ; i < input.length(); i++) {
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
