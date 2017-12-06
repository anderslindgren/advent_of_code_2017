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
public class Day1_2 {

    public static void main(String... args) throws IOException {
        Day1_2 day = new Day1_2();
        List<String> input = day.parseArgs(args);
        int[] numbers = day.toIntArray(input.get(0));
        int sum = day.parse(numbers);
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
        final int length = ints.length;
        final int half = length / 2;
        for (int i = 0; i < length; i++) {
            final int other = (i + half) % length;
            if (ints[i] == ints[other]) {
                result += ints[i];
            }
        }
        return result;
    }

}
