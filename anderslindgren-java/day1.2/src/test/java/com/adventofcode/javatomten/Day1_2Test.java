package com.adventofcode.javatomten;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Day1_2Test {

    private Day1_2 day;

    @Before
    public void setup() {
        day = new Day1_2();
    }

    @Test
    public void shoudReturn6() {
        assertThat(day.parse(day.toIntArray("1212")), equalTo(6));
    }

    @Test
    public void shoudReturn0() {
        assertThat(day.parse(day.toIntArray("1221")), equalTo(0));
    }
    @Test
    public void shoudReturn4() {
        assertThat(day.parse(day.toIntArray("123425")), equalTo(4));
    }

    @Test
    public void shoudReturn12() {
        assertThat(day.parse(day.toIntArray("123123")), equalTo(12));
    }

    @Test
    public void shoudAlsoReturn4() {
        assertThat(day.parse(day.toIntArray("12131415")), equalTo(4));
    }
}
