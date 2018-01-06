package com.adventofcode.javatomten;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        long result = input.stream()
                .filter(solution::checkPassString)
                .count();

        final String dir = getProperty("user.dir");
        System.out.println(format("%s: %d", dir.substring(dir.lastIndexOf("/") + 1), result));

    }

    boolean checkPassString(String input) {
        String[] strings = input.split(" ");
        Set<String> passPhrase = new HashSet<>();
        for (String s : strings) {
            if (passPhrase.contains(s)) {
                return false;
            }
            passPhrase.add(s);
        }
        return true;
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
