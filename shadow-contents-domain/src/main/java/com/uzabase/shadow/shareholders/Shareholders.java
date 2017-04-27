package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.name.Name;
import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.period.PeriodType;
import com.uzabase.shadow.util.CollectionSupporter;
import lombok.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * Shareholders First Class Collection
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
@Value
public class Shareholders implements CollectionSupporter<Shareholder> {

    public static final Shareholders EMPTY = new Shareholders(Collections.emptyList());

    private List<Shareholder> shareholders;

    // TODO - more methods here

    public Shareholders limit(Limit limit) {
        return new Shareholders(shareholders.stream().limit(limit.getValue()).collect(Collectors.toList()));
    }

    public Map<PeriodType, List<Shareholder>> splitByPeriodType() {
        return stream().collect(groupingBy(e -> e.getPeriod().getPeriodCode()));
    }

    public Map<Name, List<Shareholder>> splitByName() {
        return stream().collect(Collectors.groupingBy(Shareholder::getName, LinkedHashMap::new, Collectors.mapping(Function.identity(), Collectors.toList())));
    }

    @Override
    public Iterator<Shareholder> iterator() {
        return shareholders.iterator();
    }
}
