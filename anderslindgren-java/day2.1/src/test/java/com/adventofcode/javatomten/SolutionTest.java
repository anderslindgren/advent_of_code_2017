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
    public void shoudReturn18() {
        List<String> input = asList("5 1 9 5", "7 5 3", "2 4 6 8");
        assertThat(solution.parse(input), equalTo(18));
    }

}
