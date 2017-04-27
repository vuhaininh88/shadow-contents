package com.uzabase.shadow.shareholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Shareholder JSON for API
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareholderJson {

    private String name;
    private List<ShareholderPeriodJson> periods;
}
