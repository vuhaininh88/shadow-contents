package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.financial.period.PeriodTypes;
import com.uzabase.shadow.name.Name;
import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.period.PeriodType;
import com.uzabase.shadow.sort.SortType;
import com.uzabase.shadow.util.CollectionSupporter;
import lombok.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Shareholders First Class Collection
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
@Value
public class Shareholders implements CollectionSupporter<Shareholder> {

    public static final Shareholders EMPTY = new Shareholders(Collections.emptyList());

    private List<Shareholder> shareholders;

    public Shareholders byPeriods(PeriodTypes periodTypes) {
        Map<PeriodType, List<Shareholder>> byPeriodType = splitByPeriodType();
        List<Shareholder> filtered = periodTypes.getPeriodTypes().stream().map(byPeriodType::get).filter(Objects::nonNull).flatMap(Collection::stream).collect(toList());
        return new Shareholders(filtered);
    }

    public Shareholders sort(SortType sort) {
        Map<PeriodType, List<Shareholder>> byPeriodType = splitByPeriodType();

        if (sort == SortType.DESCENDING) {
            List<Shareholder> list = new ArrayList<>();
            list.addAll(Optional.ofNullable(byPeriodType.get(PeriodType.FY4)).map(e -> e.stream().sorted(reverseOrder()).collect(toList())).orElse(Collections.emptyList()));
            list.addAll(Optional.ofNullable(byPeriodType.get(PeriodType.HF1)).map(e -> e.stream().sorted(reverseOrder()).collect(toList())).orElse(Collections.emptyList()));
            return new Shareholders(list);
        }

        List<Shareholder> list = new ArrayList<>();
        list.addAll(Optional.ofNullable(byPeriodType.get(PeriodType.FY4)).map(e -> e.stream().sorted().collect(toList())).orElse(Collections.emptyList()));
        list.addAll(Optional.ofNullable(byPeriodType.get(PeriodType.HF1)).map(e -> e.stream().sorted().collect(toList())).orElse(Collections.emptyList()));
        return new Shareholders(list);
    }

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

    public int size() {
        return shareholders.size();
    }
}
