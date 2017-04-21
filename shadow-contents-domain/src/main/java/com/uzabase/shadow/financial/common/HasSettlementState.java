package com.uzabase.shadow.financial.common;

import com.uzabase.shadow.financial.SettlementState;

/**
 * Interface to hold contracts about Settlement State
 * <p>
 * Created by Trung-Vu on 2017/04/19.
 */
public interface HasSettlementState {

    SettlementState getSettlementState();

    default String getSettlementNumber() {
        return getSettlementState().getSettlementNumber();
    }

    default int getSettlementValue() {
        return getSettlementState().getStateValue();
    }

    default boolean isAnomaly() {
        return getSettlementState().isAnomaly();
    }

    default boolean isSameSettlementState(SettlementState other) {
        return getSettlementState().equals(other);
    }
}
