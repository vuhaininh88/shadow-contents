package com.uzabase.shadow.financial.period;

import com.uzabase.shadow.date.AccountingPeriodDate;
import com.uzabase.shadow.date.FiscalYear;
import com.uzabase.shadow.financial.SettlementState;
import com.uzabase.shadow.financial.common.HasSettlementState;
import com.uzabase.shadow.period.PeriodType;
import lombok.Value;

import java.time.Year;
import java.util.List;
import java.util.Optional;

/**
 * Period class for Shareholder, contains some attributes like as PeriodType, FiscalYear and other attributes like that.
 * <p>
 * Created by Trung-Vu on 2017/04/19.
 */
@Value
public class Period implements Comparable<Period>, HasSettlementState {

    private PeriodType periodCode;

    private FiscalYear fiscalYear;

    private Optional<AccountingPeriodDate> accountingPeriodDate;

    private SettlementState settlementState;

    public int getFiscalYearAsInt() {
        return fiscalYear.getIntValue();
    }

    public static Period of(String periodCode, int fiscalYear, int accountingPeriod, int settlementState) {
        return new Period(PeriodType.get(periodCode), FiscalYear.of(fiscalYear), Optional.of(AccountingPeriodDate.of(accountingPeriod)), new SettlementState(settlementState));
    }

    public static Period of(PeriodType type, int fiscalYear, int accountingPeriod, int settlementState) {
        return new Period(type, FiscalYear.of(fiscalYear), Optional.of(AccountingPeriodDate.of(accountingPeriod)), new SettlementState(settlementState));
    }

    public static Period of(PeriodType type, int fiscalYear, Optional<AccountingPeriodDate> accountingPeriod, int settlementState) {
        return new Period(type, FiscalYear.of(fiscalYear), accountingPeriod, new SettlementState(settlementState));
    }

    public static Period of(PeriodType type, Year fiscalYear, int accountingPeriod, int settlementState) {
        return new Period(type, new FiscalYear(fiscalYear), Optional.of(AccountingPeriodDate.of(accountingPeriod)), new SettlementState(settlementState));
    }

    public static Period of(PeriodType type, Year year, Optional<AccountingPeriodDate> accountingPeriod, SettlementState settlementState) {
        return new Period(type, new FiscalYear(year), accountingPeriod, settlementState);
    }

    public boolean isSamePeriodType(PeriodType type) {
        return periodCode.equals(type);
    }

    public boolean isForecast() {
        return periodCode.isFF4();
    }

    public boolean isLTM() {
        return periodCode.isLTM();
    }

    @Override
    public int compareTo(Period o) {
        int compareTo = fiscalYear.getValue().compareTo(o.fiscalYear.getValue());
        if (compareTo == 0) {
            List<PeriodType> sort = PeriodType.DEFAULT_SORT;
            if (sort.indexOf(periodCode) == -1) return Integer.MAX_VALUE;
            return sort.indexOf(periodCode) - sort.indexOf(o.periodCode);
        }
        return compareTo;
    }
}
