package com.uzabase.shadow.date;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung-Vu on 2017/05/09.
 */
public class AccountingPeriodDateTest {

    @Test
    public void returnIntValueWhenPeriodDateIsYearMonth() throws Exception {
        assertThat(AccountingPeriodDate.of(201712).getIntValue(), Is.is(201712));
    }

    @Test
    public void returnStringValueWhenPeriodDateIsYearMonth() throws Exception {
        assertThat(AccountingPeriodDate.of(201712).getStringValue(), Is.is("2017-12"));
    }
}