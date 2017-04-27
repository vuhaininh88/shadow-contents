package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.entity.common.speeda.ShrHld;
import com.uzabase.shadow.shareholders.Shareholder;
import com.uzabase.shadow.shareholders.Shareholders;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ShareholderFactory to create new instance of Shareholders via a list of ShrHld
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
public class ShareholderFactory {

    public Shareholders create(List<ShrHld> shrHlds) {
        return new Shareholders(
                shrHlds.stream()
                        .map(e -> Shareholder.of(e.getZcShrHldNameVch(), e.getAccSttlCd(), e.getAccSttlYear(), e.getShrHldNum(), e.getShrHldRtoNum(), e.getAccSttlPeriodNum(), e.getAnmlAccSttlSgn()))
                        .collect(Collectors.toList())
        );
    }

}
