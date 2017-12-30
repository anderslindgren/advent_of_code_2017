package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters(name = "{0} => {1}")
    public static Object[][] data() {
        return new Object[][]{
                {1, 1},
                {2, 4},
                {3, 4},
                {4, 5},
                {5, 10},
                {9, 10},
                {10, 11},
                {11, 23},
                {23, 25},
                {25, 26},
                {26, 54},
                {53, 54},
                {54, 57},
                {56, 57},
                {57, 59},
                {59, 122},
                {121, 122},
                {122, 133},
                /*
                { 14, 122 },
                { 15, 133 },
                { 16, 143 },
                { 17, 147 },
                { 18, 304 },
                { 19, 330 },
                { 20, 351 },
                { 21, 362 },
                { 22, 747 },
                { 23, 806 },
                */
        };
    }

    @Parameterized.Parameter
    public int input;

    @Parameterized.Parameter(1)
    public int expected;

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        assertThat(solution.solve(input), equalTo(expected));
    }

}
