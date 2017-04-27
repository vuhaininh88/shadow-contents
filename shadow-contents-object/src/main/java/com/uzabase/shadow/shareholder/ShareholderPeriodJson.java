package com.uzabase.shadow.shareholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trung-Vu on 2017/04/27.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShareholderPeriodJson {

    private String periodCode;
    private String fiscalYear;
    private ShareholderItemJson numberOfShares;
    private ShareholderItemJson shareRatio;
}
