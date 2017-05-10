package com.uzabase.shadow.sort;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/10.
 */
public class SortTypeTest {

    @Test
    public void createSortTypeByInputAsString() throws Exception {
        assertThat(SortType.get("asc").getText(), Is.is("asc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionWhenGettingByInvalidValue() throws Exception {
        assertThat(SortType.get("invalid").getText(), Is.is("asc"));
    }
}