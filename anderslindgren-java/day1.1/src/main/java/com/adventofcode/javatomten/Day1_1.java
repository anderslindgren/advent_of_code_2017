package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.Integer.parseInt;

/**
 * Advent of Code 2017-12-01.
 */
public class Day1_1 {

    public static void main(String... args) throws IOException {
        Day1_1 day = new Day1_1();
        int[] numbers = day.parseArgs(args);
        int sum = day.parse(numbers);
        System.out.println(sum);
    }

    private int[] parseArgs(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("expected arguments: <input file name>");
            System.exit(1);
        }
        Path path = FileSystems.getDefault().getPath(args[0]);
        BufferedReader reader = Files.newBufferedReader(path);
        String line = reader.readLine();
        int[] result = new int[line.length()];
        for (int i = 0 ; i < line.length(); i++) {
            result[i] = parseInt(Character.toString(line.charAt(i)));
        }
        return result;
    }

    private int parse(int[] ints) {
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
