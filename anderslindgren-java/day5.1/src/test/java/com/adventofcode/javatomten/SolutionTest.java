package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameters(name = "{0} => {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"0 3 0 1 -3", 5},
                {"0 0 0 0", 8},
                {"1 1 1 1", 4},
                {"0 1 2 3", 4},
                {"10 1 2 3", 1},
        };
    }

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public int expected;

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        int[] input = Arrays.stream(this.input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertThat(solution.followJumps(input), equalTo(expected));
    }

}
