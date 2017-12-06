package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void shoudReturn6() {
        assertThat(solution.parse(solution.toIntArray("1212")), equalTo(6));
    }

    @Test
    public void shoudReturn0() {
        assertThat(solution.parse(solution.toIntArray("1221")), equalTo(0));
    }
    @Test
    public void shoudReturn4() {
        assertThat(solution.parse(solution.toIntArray("123425")), equalTo(4));
    }

    @Test
    public void shoudReturn12() {
        assertThat(solution.parse(solution.toIntArray("123123")), equalTo(12));
    }

    @Test
    public void shoudAlsoReturn4() {
        assertThat(solution.parse(solution.toIntArray("12131415")), equalTo(4));
    }
}
