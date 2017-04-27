package com.uzabase.shadow.number;

import com.uzabase.shadow.util.HasStringValue;
import lombok.Value;

/**
 * Created by Trung-Vu on 2017/04/27.
 */
@Value
public class Limit implements HasStringValue {

    private int value;

    public static Limit of(String value) {
        return new Limit(Integer.parseInt(value));
    }

    @Override
    public String getStringValue() {
        return String.valueOf(value);
    }

    public Limit decrement() {
        return new Limit(value - 1);
    }

    public boolean isOne() {
        return value == 1;
    }
}
