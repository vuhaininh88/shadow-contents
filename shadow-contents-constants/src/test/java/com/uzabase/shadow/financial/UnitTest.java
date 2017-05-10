package com.uzabase.shadow.financial;

import mockit.Tested;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung-Vu on 2017/04/17.
 */
public class UnitTest {

    @Tested
    private Unit unit;

    @Test
    public void getUnitViaStringInput() throws Exception {
        assertThat(Unit.get("％").getSimpleName(), Is.is("percent"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidUnit() throws Exception {
        assertThat(Unit.get("invalid").getSimpleName(), Is.is("invalid"));
    }
}