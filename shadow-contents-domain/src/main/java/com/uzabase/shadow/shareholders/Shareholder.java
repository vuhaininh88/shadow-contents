package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.financial.Unit;
import com.uzabase.shadow.financial.period.Period;
import com.uzabase.shadow.main.Name;
import com.uzabase.shadow.period.PeriodType;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Shareholder class, contains some of information like as Name, Period, ShareholderItem
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
@Value
public class Shareholder implements Comparable<Shareholder> {

    private Name name;
    private Period period;
    private ShareholderItem numberOfShareholders;
    private ShareholderItem shareRatio;

    public static Shareholder of(String name, String type, int year, long numberOfShares, BigDecimal ratio, int accountingPeriodDate, int settlementState) {
        return new Shareholder(
                new Name(name),
                Period.of(PeriodType.valueOf(type), year, accountingPeriodDate, settlementState),
                ShareholderItem.of(new BigDecimal(numberOfShares), Unit.SHARES),
                ShareholderItem.of(ratio, Unit.PERCENT));
    }

    @Override
    public int compareTo(Shareholder o) {
        return numberOfShareholders.compareTo(o.getNumberOfShareholders());
    }
}
