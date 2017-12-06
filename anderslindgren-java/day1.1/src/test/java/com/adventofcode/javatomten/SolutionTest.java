package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void shoudReturn3() {
        assertThat(solution.parse(solution.toIntArray("1122")), equalTo(3));
    }

    @Test
    public void shoudReturn4() {
        assertThat(solution.parse(solution.toIntArray("1111")), equalTo(4));
    }

    @Test
    public void shoudReturn0() {
        assertThat(solution.parse(solution.toIntArray("1234")), equalTo(0));
    }

    @Test
    public void shoudReturn9() {
        assertThat(solution.parse(solution.toIntArray("91212129")), equalTo(9));
    }
}
