package com.uzabase.shadow.financial;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Class to define each unit in system, including some units like percent, times, people or days, shares...
 * <p>
 * Created by Trung-Vu on 2017/04/17.
 */
@AllArgsConstructor
@Getter
public enum Unit {

    DECIMAL("変換円", "decimal"), PERCENT("%", "percent"), TIMES("倍", "times"), PEOPLE("人", "people"),
    DAYS("日", "days"), SHARES("株", "shares"), RATIO("回", "ratio"), SHOP("点", "shop"), AGE("歳", "age"), COMPANIES("社", "companies");

    private String code;
    private String simpleName;

    public static Unit get(String code) {
        String newCode = Optional.of(code).filter(e -> e.equals("％")).map(e -> "%").orElse(code);
        return Arrays.stream(values()).filter(e -> e.code.equals(newCode)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("code is [%s]", code)));
    }
}
