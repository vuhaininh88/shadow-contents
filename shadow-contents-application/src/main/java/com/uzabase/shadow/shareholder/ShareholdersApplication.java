package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.GlobalId;
import com.uzabase.shadow.financial.period.PeriodTypes;
import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.shareholders.Shareholders;
import com.uzabase.shadow.sort.SortType;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * ShareholdersApplication is used in API layer to interact with user interface
 * <p>
 * Created by Trung-Vu on 2017/05/06.
 */
@Named
public class ShareholdersApplication {

    @Inject
    private ShareholdersRepository shareholdersRepository;

    public Shareholders getLatestShareholders(GlobalId globalId, PeriodTypes periodTypes, Limit limit, SortType sort) {
        return shareholdersRepository.findByGlobalId(globalId).byPeriods(periodTypes).sort(sort).limit(limit);
    }
}
