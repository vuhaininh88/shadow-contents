package com.uzabase.shadow.period;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung Vu on 2017/05/10.
 */
public class PeriodTypeTest {

    @Test
    public void createPeriodTypeViaStringCode() throws Exception {
        assertThat(PeriodType.get("FY4").getStringValue(), Is.is("FY4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidCode() throws Exception {
        assertThat(PeriodType.get("invalid").getStringValue(), Is.is("invalid"));
    }

    @Test
    public void isFY4ReturnTrueWhenCodeIsFY4() throws Exception {
        assertTrue(PeriodType.get("FY4").isFY4());
    }

    @Test
    public void isFY4ReturnFalseWhenCodeIsFY4() throws Exception {
        assertFalse(PeriodType.get("FF4").isFY4());
    }

    @Test
    public void isCY4ReturnTrueWhenCodeIsCY4() throws Exception {
        assertTrue(PeriodType.get("CY4").isCY4());
    }

    @Test
    public void isCY4ReturnFalseWhenCodeIsCY4() throws Exception {
        assertFalse(PeriodType.get("FY4").isCY4());
    }
}