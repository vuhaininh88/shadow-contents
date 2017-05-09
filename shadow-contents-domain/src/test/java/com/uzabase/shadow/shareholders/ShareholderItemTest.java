package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.financial.ItemValue;
import com.uzabase.shadow.financial.Unit;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class ShareholderItemTest {

    @Test
    public void getItemValueAsBigDecimal() throws Exception {
        assertThat(new ShareholderItem(new ItemValue(new BigDecimal(1000)), Unit.PERCENT).getItemValueAsBigDecimal(), Is.is(new BigDecimal(1000)));
    }

    @Test
    public void getSimepleNameAsString() throws Exception {
        assertThat(new ShareholderItem(new ItemValue(new BigDecimal(1000)), Unit.PERCENT).getUnitSimpleName(), Is.is("percent"));
    }
}