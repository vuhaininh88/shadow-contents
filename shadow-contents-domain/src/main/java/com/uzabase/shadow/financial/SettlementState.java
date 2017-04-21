package com.uzabase.shadow.financial;

import com.google.common.base.Strings;
import lombok.Value;

/**
 * Created by Trung-Vu on 2017/04/18.
 */
@Value
public class SettlementState {

    private static final int ANOMALY_VALUE = 0;

    private int stateValue;

    public String getSettlementNumber() {
        return Strings.padStart(String.valueOf(stateValue), 2, '0');
    }

    public boolean isAnomaly() {
        return this.stateValue == ANOMALY_VALUE;
    }
}
