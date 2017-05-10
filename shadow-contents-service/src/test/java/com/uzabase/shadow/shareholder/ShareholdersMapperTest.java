package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.shareholders.Shareholder;
import com.uzabase.shadow.shareholders.Shareholders;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/10.
 */
public class ShareholdersMapperTest {

    @Test
    public void mapShareholdersToJsonObject() throws Exception {
        Shareholder shareholder = Shareholder.of("shadow", "FY4", 2017, 1, new BigDecimal(10), 201712, 0);
        Shareholders shareholders = new Shareholders(Arrays.asList(shareholder));

        ShareholdersJson actual = new ShareholdersMapper().map(shareholders);
        assertThat(actual.getShareholders().size(), is(1));

        ShareholderJson jsonActual = actual.getShareholders().get(0);
        assertThat(jsonActual.getName(), is("shadow"));
        assertThat(jsonActual.getPeriods().size(), is(1));

        ShareholderPeriodJson periodJson = jsonActual.getPeriods().get(0);
        assertThat(periodJson.getPeriodCode(), is("FY4"));
        assertThat(periodJson.getFiscalYear(), is("2017"));
        assertThat(periodJson.getNumberOfShares().getValue(), is(new BigDecimal(1)));
        assertThat(periodJson.getNumberOfShares().getUnit(), is("shares"));
        assertThat(periodJson.getShareRatio().getValue(), is(new BigDecimal(10)));
        assertThat(periodJson.getShareRatio().getUnit(), is("percent"));
    }
}