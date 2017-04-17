package com.uzabase.shadow.financial;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Item value
 * 
 * Created by Trung-Vu on 2017/04/17.
 */
@Data
public class ItemValue implements Comparable<ItemValue> {

    private final BigDecimal value;

    public int compareTo(ItemValue o) {
        return value.compareTo(o.getValue());
    }
}