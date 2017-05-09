package com.uzabase.shadow.financial.period;

import com.uzabase.shadow.period.PeriodType;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class PeriodTest {

    @Test
    public void isForceCastReturnTrueWhenValueIsFY4() throws Exception {
        assertTrue(Period.of(PeriodType.FF4, 2014, 201012, 0).isForecast());
    }

    @Test
    public void isForceCastReturnFalseWhenValueIsNotFY4() throws Exception {
        assertFalse(Period.of(PeriodType.CN4, 2014, 201012, 0).isForecast());
    }

    @Test
    public void returnTrueWhenPeriodTypesAreSame() throws Exception {
        assertTrue(Period.of(PeriodType.FY4, 2014, 201012, 0).isSamePeriodType(PeriodType.FY4));
    }

    @Test
    public void returnFalseWhenPeriodTypesAreNotSame() throws Exception {
        assertFalse(Period.of(PeriodType.FY4, 2014, 201012, 0).isSamePeriodType(PeriodType.CN4));
    }

    @Test
    public void isLTMReturnTrueWhenValueIsLTM() throws Exception {
        assertTrue(Period.of(PeriodType.LTM, 2014, 201012, 0).isLTM());
    }

    @Test
    public void isLTMReturnFalseWhenValueIsNotLTM() throws Exception {
        assertFalse(Period.of(PeriodType.CN4, 2014, 201012, 0).isLTM());
    }
}