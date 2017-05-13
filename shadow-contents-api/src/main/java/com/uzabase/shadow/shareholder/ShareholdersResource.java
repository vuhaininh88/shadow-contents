package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.GlobalId;
import com.uzabase.shadow.financial.period.PeriodTypes;
import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.shareholders.Shareholders;
import com.uzabase.shadow.sort.SortType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by Trung-Vu on 2017/05/06.
 */
@RestController
@RequestMapping(value = "/contents/companies")
public class ShareholdersResource {

    @Inject
    private ShareholdersApplication shareholdersApplication;
    @Inject
    private ShareholdersMapper mapper;

    @RequestMapping(value = "/shareholders", method = RequestMethod.GET)
    @Cacheable("shareholders")
    public ShareholdersJson getShareholders(@RequestParam(value = "globalId") GlobalId globalId,
                                            @RequestParam(value = "periods", required = false, defaultValue = "FY4") PeriodTypes types,
                                            @RequestParam(value = "limit", required = false, defaultValue = "11") Limit limit,
                                            @RequestParam(value = "sort", required = false, defaultValue = "DESCENDING") SortType sortType) {
        Shareholders shareholders = shareholdersApplication.getLatestShareholders(globalId, types, limit, sortType);
        return mapper.map(shareholders);
    }
}
