package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.entity.common.speeda.ShrHld;
import com.uzabase.shadow.shareholders.Shareholder;
import com.uzabase.shadow.shareholders.Shareholders;
import mockit.Tested;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/11.
 */
public class ShareholdersFactoryTest {

    @Tested
    ShareholdersFactory factory;

    @Test
    public void createShareholdersByUsingFactoryMethod() throws Exception {
        ShrHld shrHld = new ShrHld();
        shrHld.setAccSttlYear(2017);
        shrHld.setGlobalId("SHADOW2017");
        shrHld.setAccSttlCd("FY4");
        shrHld.setAccSttlPeriodNum(201712);

        Shareholders shareholders = factory.create(Arrays.asList(shrHld));
        assertThat(shareholders.size(), is(1));

        Shareholder shareholder = shareholders.getShareholders().get(0);
        assertThat(shareholder.getPeriod().getFiscalYear().getIntValue(), is(2017));
        assertThat(shareholder.getPeriod().getPeriodCode().getStringValue(), is("FY4"));
    }
}