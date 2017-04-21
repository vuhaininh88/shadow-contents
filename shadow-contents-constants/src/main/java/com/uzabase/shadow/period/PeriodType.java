package com.uzabase.shadow.period;

import com.uzabase.shadow.util.HasStringValue;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * Class to define constants about period relative with financial times.
 * <p>
 * Created by Trung-Vu on 2017/04/17.
 */
@AllArgsConstructor
public enum PeriodType implements HasStringValue {

    FY4("FY4"),
    LTM("LTM"),
    CQ3("CQ3"),
    CN4("CN4"),
    CY4("CY4"),
    HF1("HF1"),
    HF2("HF2"),
    QT1("QT1"),
    QT2("QT2"),
    QT3("QT3"),
    QT4("QT4"),
    FF4("FF4"),
    FH2("FH2"),
    TF4("TF4"),
    TH2("TH2"),
    TN4("TN4"),
    PTM("PTM");

    private String code;

    public static List<PeriodType> DEFAULT_SORT = Arrays.asList(FY4, LTM, CY4, FF4, HF1, HF2);

    public static PeriodType get(String code) {
        return Arrays.stream(values()).filter(e -> e.code.equals(code)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("args is [%s]", code)));
    }

    @Override
    public String getStringValue() {
        return code;
    }

    public boolean isCY4() {
        return this == CY4;
    }

    public boolean isFY4() {
        return this == FY4;
    }

    public boolean isLTM() {
        return this == LTM;
    }

    public boolean isFF4() {
        return this == FF4;
    }
}
