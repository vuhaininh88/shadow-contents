package com.uzabase.shadow.date;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung-Vu on 2017/05/09.
 */
public class FiscalYearTest {

    @Test
    public void getValueAsStringWithFormatYYYY() throws Exception {
        assertThat(FiscalYear.of(2017).getStringValue(), Is.is("2017"));
    }

    @Test
    public void getValueAsIntValue() throws Exception {
        assertThat(FiscalYear.of(2017).getIntValue(), Is.is(2017));
    }

    @Test
    public void getLocalDate() throws Exception {
        assertThat(FiscalYear.of(2017).getLocalDate(), Is.is(LocalDate.of(2017, 01, 01)));
    }

    @Test
    public void minusOneYear() throws Exception {
        assertThat(FiscalYear.of(2017).minusOneYear(), Is.is(FiscalYear.of(2016)));
    }
}