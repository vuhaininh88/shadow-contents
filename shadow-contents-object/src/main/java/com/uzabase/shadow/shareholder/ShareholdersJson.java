package com.uzabase.shadow.shareholder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ShareholderJson First Class Collection for API
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareholdersJson {

    private List<ShareholderJson> shareholders;
}
