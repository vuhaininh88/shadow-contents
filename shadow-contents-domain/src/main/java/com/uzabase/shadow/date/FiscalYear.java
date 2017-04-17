package com.uzabase.shadow.date;

import com.uzabase.shadow.util.HasIntValue;
import com.uzabase.shadow.util.HasLocalDate;
import com.uzabase.shadow.util.HasStringValue;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 * Fiscal Year
 * <p>
 * Created by Trung-Vu on 2017/04/17.
 */
@Value
public class FiscalYear implements Comparable<FiscalYear>, HasStringValue, HasIntValue, HasLocalDate {

    private static final DateTimeFormatter formatter = DatePattern.YYYY.createDateTimeFormatter();

    private final Year value;

    public static FiscalYear of(int value) {
        return new FiscalYear(Year.of(value));
    }

    @Override
    public int compareTo(FiscalYear o) {
        return value.compareTo(o.getValue());
    }

    @Override
    public String getStringValue() {
        return value.format(formatter);
    }

    @Override
    public int getIntValue() {
        return value.getValue();
    }

    @Override
    public LocalDate getLocalDate() {
        return value.atMonth(1).atDay(1);
    }

    public FiscalYear minusOneYear() {
        return new FiscalYear(value.minusYears(1L));
    }
}
