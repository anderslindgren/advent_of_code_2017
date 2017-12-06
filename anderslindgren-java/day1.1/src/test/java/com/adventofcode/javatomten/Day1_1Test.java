package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Day1_1Test {

    private Day1_1 day;

    @Before
    public void setup() {
        day = new Day1_1();
    }

    @Test
    public void shoudReturn3() {
        assertThat(day.parse(day.toIntArray("1122")), equalTo(3));
    }

    @Test
    public void shoudReturn4() {
        assertThat(day.parse(day.toIntArray("1111")), equalTo(4));
    }

    @Test
    public void shoudReturn0() {
        assertThat(day.parse(day.toIntArray("1234")), equalTo(0));
    }

    @Test
    public void shoudReturn9() {
        assertThat(day.parse(day.toIntArray("91212129")), equalTo(9));
    }
}
