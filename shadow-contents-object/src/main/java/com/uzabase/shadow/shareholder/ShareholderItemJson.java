package com.uzabase.shadow.shareholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Trung-Vu on 2017/04/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareholderItemJson {

    private BigDecimal value;
    private String unit;
}
