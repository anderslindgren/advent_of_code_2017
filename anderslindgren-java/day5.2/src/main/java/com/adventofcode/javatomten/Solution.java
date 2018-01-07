package com.adventofcode.javatomten;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.util.stream.Collectors.toList;

/**
 * Advent of Code 2017-12-04.
 */
public class Solution {

    public static void main(String... args) throws IOException {
        final Solution solution = new Solution();
        final List<String> input = solution.parseArgs(args);

        final int[] jumps = solution.stringAsInts(input);
        int result = solution.followJumps(jumps);

        final String dir = getProperty("user.dir");
        System.out.println(format("%s: %d", dir.substring(dir.lastIndexOf("/") + 1), result));

    }

    private int[] stringAsInts(List<String> input) {
        return input.stream().mapToInt(Integer::parseInt).toArray();
    }

    int followJumps(int[] input) {
        int jumps = 0;
        int i = 0;
        while (i < input.length) {
            final int j = i;
            i += input[j];
            jumps++;
            if (input[j] >= 3) {
                input[j]--;
            } else {
                input[j]++;
            }
        }
        return jumps;
    }

    private List<String> parseArgs(String[] args) throws IOException {
        String file = "input.txt";
        if (args.length == 1) {
            file = args[0];
        }
        Path path = FileSystems.getDefault().getPath(file);
        BufferedReader reader = Files.newBufferedReader(path);
        return reader.lines().collect(toList());
    }

}
