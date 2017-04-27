package com.uzabase.shadow.financial.period;

import com.uzabase.shadow.period.PeriodType;
import com.uzabase.shadow.util.StringCollection;
import lombok.Value;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Period Type First Class Collection
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
@Value
public class PeriodTypes implements StringCollection<PeriodType> {

    private List<PeriodType> periodTypes;

    private static final PeriodTypes STANDARD = new PeriodTypes(Arrays.asList(PeriodType.FY4, PeriodType.LTM, PeriodType.FF4));

    public static PeriodTypes of(String joined) {
        List<PeriodType> types = Arrays.stream(joined.split(",")).map(PeriodTypes::get).filter(Optional::isPresent).map(Optional::get).collect(toList());
        return new PeriodTypes(types);
    }

    private static Optional<PeriodType> get(String str) {
        try {
            return Optional.of(PeriodType.get(str));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }

    public boolean contain(PeriodType periodType) {
        return periodTypes.contains(periodType);
    }

    @Override
    public Iterator<PeriodType> iterator() {
        return periodTypes.iterator();
    }
}
