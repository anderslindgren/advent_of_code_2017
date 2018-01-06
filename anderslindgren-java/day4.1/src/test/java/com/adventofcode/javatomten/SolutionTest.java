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
                {"aa bb cc dd ee", true},
                {"aa bb cc dd aa", false},
                {"aa bb cc dd aaa", true},
        };
    }

    @Parameterized.Parameter
    public String input;

    @Parameterized.Parameter(1)
    public boolean expected;

    private Solution solution;

    @Before
    public void setup() {
        solution = new Solution();
    }

    @Test
    public void test() {
        assertThat(solution.checkPassString(input), equalTo(expected));
    }

}
