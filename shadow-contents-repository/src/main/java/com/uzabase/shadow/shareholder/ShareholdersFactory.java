package com.uzabase.shadow.shareholder;


import com.uzabase.shadow.entity.common.speeda.ShrHld;
import com.uzabase.shadow.shareholders.Shareholder;
import com.uzabase.shadow.shareholders.Shareholders;

import javax.inject.Named;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * ShareHoldersFactory to create instance of Shareholders class via Factory Method Pattern
 * <p>
 * Created by Trung Vu on 2017/05/11.
 */
@Named
public class ShareholdersFactory {

    public Shareholders create(List<ShrHld> shrHlds) {
        return new Shareholders(shrHlds.stream()
                .map(e -> Shareholder.of(
                        e.getZcShrHldNameVch(),
                        e.getAccSttlCd(),
                        e.getAccSttlYear(),
                        e.getShrHldNum(),
                        e.getShrHldRtoNum(),
                        e.getAccSttlPeriodNum(),
                        e.getAnmlAccSttlSgn()))
                .collect(toList()));
    }
}