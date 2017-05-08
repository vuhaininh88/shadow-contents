package com.uzabase.shadow;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * Created by Trung-Vu on 2017/05/01.
 */
@Value
@AllArgsConstructor
public class GlobalId implements Comparable<GlobalId> {

    private final String value;

    @Override
    public int compareTo(GlobalId o) {
        return value.compareTo(o.getValue());
    }
}