package com.uzabase.shadow.financial;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class SettlementStateTest {

    @Test
    public void getSettlementNumberWhenValueLessThan10() throws Exception {
        assertThat(new SettlementState(9).getSettlementNumber(), Is.is("09"));
    }

    @Test
    public void getSettlementNumberWhenValueGreaterThan10() throws Exception {
        assertThat(new SettlementState(11).getSettlementNumber(), Is.is("11"));
    }

    @Test
    public void isAnomalyWhenValueIsZero() throws Exception {
        assertTrue(new SettlementState(0).isAnomaly());
    }

    @Test
    public void isAnomalyReturnFalseWhenValueNotEqualZero() throws Exception {
        assertFalse(new SettlementState(11).isAnomaly());
    }
}