package com.adventofcode.javatomten;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.ceil;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.util.stream.Collectors.toList;

/**
 * Advent of Code 2017-12-03.
 */
public class Solution {

    private enum Heading {NORTH, EAST, SOUTH, WEST}

    private class Memory {
        private final int[][] board;
        private int size;
        private int x;
        private int y;
        private int northSouth;
        private int eastWest;
        private Heading heading = Heading.EAST;

        private Memory(int location) {
            size = 1;
            while ((size * size) < location) {
                size += 2;
            }
            board = new int[size][size];

            final int start = (int) ceil(size / 2);
            x = start;
            y = start;
            board[x][y] = 1;
            for (int i = 2; i <= location; i++) {
                forward(i);
            }
        }

        void printMemory() {
            for (int y = size - 1; y >= 0; y--) {
                for (int x = 0; x < size; x++) {
                    System.out.print(format("%d5 ", board[x][y]));
                }
                System.out.println();
            }
        }

        void forward(int currentValue) {
            switch (heading) {
                case NORTH:
                    northSouth += 1;
                    y += 1;
                    break;
                case EAST:
                    eastWest += 1;
                    x += 1;
                    break;
                case SOUTH:
                    northSouth -= 1;
                    y -= 1;
                    break;
                case WEST:
                    eastWest -= 1;
                    x -= 1;
                    break;
            }
            if (shouldTurn()) {
                turnLeft();
            }
            board[x][y] = currentValue;
        }

        private boolean shouldTurn() {
            switch (heading) {
                case NORTH:
                    return getWestValue() == 0;
                case EAST:
                    return getNorthValue() == 0;
                case SOUTH:
                    return getEastValue() == 0;
                case WEST:
                    return getSouthValue() == 0;
                default:
                    return false;
            }
        }

        void turnLeft() {
            switch (heading) {
                case NORTH:
                    heading = Heading.WEST;
                    break;
                case EAST:
                    heading = Heading.NORTH;
                    break;
                case SOUTH:
                    heading = Heading.EAST;
                    break;
                case WEST:
                    heading = Heading.SOUTH;
                    break;
            }
        }

        private int getWestValue() {
            return board[x - 1][y];
        }

        private int getNorthValue() {
            return board[x][y + 1];
        }

        private int getEastValue() {
            return board[x + 1][y];
        }

        private int getSouthValue() {
            return board[x][y - 1];
        }

        int getDistance() {
            return abs(northSouth) + abs(eastWest);
        }
    }

    public static void main(String... args) throws IOException {
        final Solution solution = new Solution();
        final List<String> input = solution.parseArgs(args);
        final int capacity = parseInt(input.get(0));

        int result = solution.solve(capacity);
        final String dir = getProperty("user.dir");
        System.out.println(format("%s: %d", dir.substring(dir.lastIndexOf("/") + 1), result));

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

    int solve(int capacity) {
        Memory memory = new Memory(capacity);
        return memory.getDistance();
    }

}
