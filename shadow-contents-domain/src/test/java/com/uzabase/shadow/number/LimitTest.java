package com.uzabase.shadow.number;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class LimitTest {

    @Test
    public void returnValueAsString() throws Exception {
        assertThat(Limit.of("1000").getStringValue(), Is.is("1000"));
    }

    @Test
    public void decrementOne() throws Exception {
        assertThat(Limit.of("10").decrement(), Is.is(Limit.of("9")));
    }

    @Test
    public void isOneReturnTrueWhenValueIsOne() throws Exception {
        assertTrue(Limit.of("1").isOne());
    }

    @Test
    public void isOneReturnFalseWhenValueIsOne() throws Exception {
        assertFalse(Limit.of("10").isOne());
    }
}