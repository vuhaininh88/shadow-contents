package com.uzabase.shadow.financial.period;

import com.uzabase.shadow.period.PeriodType;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class PeriodTypesTest {

    @Test
    public void returnTrueInputPeriodTypeIsExistingInPeriodTypes() throws Exception {
        assertTrue(PeriodTypes.of("FY4,LTM,FF4").contain(PeriodType.FF4));
    }

    @Test
    public void returnFalseInputPeriodTypeIsNotExistingInPeriodTypes() throws Exception {
        assertFalse(PeriodTypes.of("FY4,LTM,FF4").contain(PeriodType.CN4));
    }
}