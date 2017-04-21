package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.financial.ItemValue;
import com.uzabase.shadow.financial.Unit;
import lombok.Value;

import java.math.BigDecimal;

/**
 * Shareholder Item, contains ItemValue as BigDecimal number, Unit contains some of values like percent, times...
 * <p>
 * Created by Trung-Vu on 2017/04/19.
 */
@Value
public class ShareholderItem implements Comparable<ShareholderItem> {

    private ItemValue itemValue;
    private Unit unit;

    public static ShareholderItem of(BigDecimal itemValue, Unit unit) {
        return new ShareholderItem(new ItemValue(itemValue), unit);
    }

    @Override
    public int compareTo(ShareholderItem o) {
        return itemValue.compareTo(o.getItemValue());
    }

    public BigDecimal getItemValueAsBigDecimal() {
        return itemValue.getValue();
    }

    public String getUnitSimpleName() {
        return unit.getSimpleName();
    }
}
