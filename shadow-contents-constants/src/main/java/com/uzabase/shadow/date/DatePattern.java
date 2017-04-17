package com.uzabase.shadow.date;

import lombok.AllArgsConstructor;

import java.time.format.DateTimeFormatter;

/**
 * Enum to define some of patterns about date time format.
 * <p>
 * Created by Trung-Vu on 2017/04/17.
 */
@AllArgsConstructor
public enum DatePattern {

    YYYYMMDD("yyyyMMdd"),
    YYYY_HYPHEN_MM_HYPHEN_DD("yyyy-MM-dd"),
    YYYYMM("yyyyMM"),
    YYYY_HYPHEN_MM("yyyy-MM"),
    YYYY("yyyy");

    private String pattern;

    public DateTimeFormatter createDateTimeFormatter() {
        return DateTimeFormatter.ofPattern(pattern);
    }
}
