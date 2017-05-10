package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.GlobalId;
import com.uzabase.shadow.financial.period.PeriodTypes;
import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.shareholders.Shareholders;
import com.uzabase.shadow.sort.SortType;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trung Vu on 2017/05/11.
 */
public class ShareholdersResourceTest {
    
    @Tested ShareholdersResource shareholdersResource;
    
    @Injectable
    ShareholdersApplication shareholdersApplication;
    @Injectable ShareholdersMapper shareholdersMapper;

    @Test
    public void getShareholdersDataByGlobalID(@Mocked ShareholdersJson json, @Mocked Shareholders shareholders) throws Exception {
        GlobalId globalId = new GlobalId("SD01");
        PeriodTypes periodTypes = PeriodTypes.of("FY4");
        SortType sortType = SortType.ASCENDING;
        Limit limit = Limit.of("2");
        
        new Expectations() {{
            shareholdersApplication.getLatestShareholders(globalId, periodTypes, limit, sortType); result = shareholders;
            shareholdersMapper.map(shareholders); result = json;
        }};
        
        assertThat(shareholdersResource.getShareholders(globalId, periodTypes, limit, sortType), Is.is(json));
    }
}