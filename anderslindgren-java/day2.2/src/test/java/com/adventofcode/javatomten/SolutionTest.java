package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void shoudReturn9() {
        List<String> input = asList("5 9 2 8", "9 4 7 3", "3 8 6 5");
        assertThat(solution.parse(input), equalTo(9));
    }

}
