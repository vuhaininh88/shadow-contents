package com.uzabase.shadow.shareholder;

import com.uzabase.shadow.Mapppable;
import com.uzabase.shadow.name.Name;
import com.uzabase.shadow.shareholders.Shareholder;
import com.uzabase.shadow.shareholders.ShareholderItem;
import com.uzabase.shadow.shareholders.Shareholders;

import javax.inject.Named;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * Mapping {@link Shareholders} to {@link ShareholdersJson}
 * <p>
 * Created by Trung-Vu on 2017/05/06.
 */
@Named
public class ShareholdersMapper implements Mapppable<Shareholders, ShareholdersJson> {
    
    @Override
    public ShareholdersJson map(Shareholders source) {
        Map<Name, List<Shareholder>> shareholderMap = source.splitByName();
        return new ShareholdersJson(
                shareholderMap.entrySet()
                        .stream()
                        .map(e -> new ShareholderJson(e.getKey().getValue(), e.getValue().stream().map(this::toPeriod).collect(toList())))
                        .collect(toList()));
    }

    private ShareholderPeriodJson toPeriod(Shareholder shareholder) {
        return new ShareholderPeriodJson(
                shareholder.getPeriod().getPeriodCode().getStringValue(),
                shareholder.getPeriod().getFiscalYear().getStringValue(),
                toItem(shareholder.getNumberOfShareholders()),
                toItem(shareholder.getShareRatio()));
    }

    private ShareholderItemJson toItem(ShareholderItem item) {
        return new ShareholderItemJson(item.getItemValueAsBigDecimal(), item.getUnitSimpleName());
    }
}
