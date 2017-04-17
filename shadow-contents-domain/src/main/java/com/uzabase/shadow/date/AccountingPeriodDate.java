package com.uzabase.shadow.date;

import com.uzabase.shadow.util.HasIntValue;
import com.uzabase.shadow.util.HasStringValue;
import lombok.Value;

import java.time.YearMonth;

/**
 * Accounting Period Date
 * <p>
 * Created by Trung-Vu on 2017/04/17.
 */
@Value
public class AccountingPeriodDate implements Comparable<AccountingPeriodDate>, HasStringValue, HasIntValue {

    private YearMonth yearMonth;

    public static AccountingPeriodDate of(int yearMonth) {
        return new AccountingPeriodDate(YearMonth.of(
                Integer.valueOf(String.valueOf(yearMonth).substring(0, 4)),
                Integer.valueOf(String.valueOf(yearMonth).substring(4, 6))));
    }

    @Override
    public int compareTo(AccountingPeriodDate o) {
        return yearMonth.compareTo(o.yearMonth);
    }

    @Override
    public int getIntValue() {
        return Integer.valueOf(yearMonth.format(DatePattern.YYYYMM.createDateTimeFormatter()));
    }

    @Override
    public String getStringValue() {
        return yearMonth.format(DatePattern.YYYY_HYPHEN_MM.createDateTimeFormatter());
    }
}
