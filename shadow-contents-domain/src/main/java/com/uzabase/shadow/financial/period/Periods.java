package com.uzabase.shadow.financial.period;

import com.uzabase.shadow.util.CollectionSupporter;
import lombok.Value;

import java.util.Iterator;
import java.util.List;

/**
 * Period First Class Collection
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
@Value
public class Periods implements CollectionSupporter<Period> {

    private List<Period> periods;

    @Override
    public Iterator<Period> iterator() {
        return periods.iterator();
    }
}
