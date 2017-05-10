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

import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/11.
 */
public class ShareholdersApplicationTest {

    @Tested
    ShareholdersApplication shareholdersApplication;
    
    @Injectable
    ShareholdersRepository shareholdersRepository;

    @Test
    public void getLatestDataOfShareholdersAndSortByASC(@Mocked Shareholders shareholders) throws Exception {
        GlobalId globalId = new GlobalId("SD01");
        PeriodTypes periodTypes = PeriodTypes.of("FY4");
        Limit limit = Limit.of("5");
        SortType sortType = SortType.ASCENDING;

        new Expectations() {{
            shareholdersRepository.findByGlobalId(globalId); result = shareholders;
            shareholders.byPeriods(periodTypes); result = shareholders;
            shareholders.sort(sortType); result = shareholders;
            shareholders.limit(limit); result = shareholders;
        }};

        assertThat(shareholdersApplication.getLatestShareholders(globalId, periodTypes, limit, sortType), Is.is(shareholders));
    }
}