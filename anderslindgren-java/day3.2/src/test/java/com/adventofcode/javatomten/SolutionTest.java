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

    @Parameters(name="{0} => {1}")
    public static Object[][] data() {
        return new Object[][] {
                { 1, 0 },
                { 2, 1 },
                { 3, 2 },
                { 4, 1 },
                { 5, 2 },
                { 6, 1 },
                { 7, 2 },
                { 8, 1 },
                { 9, 2 },
                { 10, 3 },
                { 25, 4 },
                { 26, 5 },
                { 27, 4 },
                { 28, 3 },
                { 29, 4 },
                { 30, 5 },
                { 31, 6 },
                { 46, 3 },
                { 47, 4 },
                { 48, 5 },
                { 49, 6 },
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
