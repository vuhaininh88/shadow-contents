package com.uzabase.shadow.sort;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;

/**
 * Enum to store type of sorting, contains ASC and DESC type
 * <p>
 * Created by Trung-Vu on 2017/05/06.
 */
@ToString
@Getter
@AllArgsConstructor
public enum SortType {

    ASCENDING("asc"),
    DESCENDING("desc");

    private String text;

    public static SortType get(String str) {
        return Arrays.stream(values()).filter(e -> e.text.equals(str)).findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("args is [%s]", str)));
    }
}
