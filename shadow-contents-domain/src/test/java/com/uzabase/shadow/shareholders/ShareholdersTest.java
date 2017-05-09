package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.number.Limit;
import com.uzabase.shadow.sort.SortType;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by Trung Vu on 2017/05/09.
 */
public class ShareholdersTest {

    @Test
    public void limitShareholders() throws Exception {
        Assert.assertThat(createTemplateShareholders().limit(Limit.of("2")).size(), Is.is(2));
    }

    @Test
    public void sortFY4ByASC() throws Exception {
        Shareholder h1 = Shareholder.of("name1", "FY4", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h2 = Shareholder.of("name2", "FY4", 2014, 50, new BigDecimal(30.0), 201010, 0);
        Shareholder h3 = Shareholder.of("name3", "HF1", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h4 = Shareholder.of("name4", "HF1", 2014, 50, new BigDecimal(30.0), 201010, 0);

        Shareholders afterSortingShareholders = new Shareholders(Arrays.asList(h1, h2, h3, h4)).sort(SortType.ASCENDING);

        Assert.assertThat(afterSortingShareholders.getShareholders().get(0), Is.is(h2));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(1), Is.is(h1));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(2), Is.is(h4));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(3), Is.is(h3));
    }

    @Test
    public void sortFY4ByDESC() throws Exception {
        Shareholder h1 = Shareholder.of("name1", "FY4", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h2 = Shareholder.of("name2", "FY4", 2014, 50, new BigDecimal(30.0), 201010, 0);
        Shareholder h3 = Shareholder.of("name3", "HF1", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h4 = Shareholder.of("name4", "HF1", 2014, 50, new BigDecimal(30.0), 201010, 0);

        Shareholders afterSortingShareholders = new Shareholders(Arrays.asList(h1, h2, h3, h4)).sort(SortType.DESCENDING);


        Assert.assertThat(afterSortingShareholders.getShareholders().get(0), Is.is(h1));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(1), Is.is(h2));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(2), Is.is(h3));
        Assert.assertThat(afterSortingShareholders.getShareholders().get(3), Is.is(h4));
    }

    private Shareholders createTemplateShareholders() {
        Shareholder h1 = Shareholder.of("name1", "FY4", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h2 = Shareholder.of("name2", "FY4", 2014, 50, new BigDecimal(30.0), 201010, 0);
        Shareholder h3 = Shareholder.of("name3", "HF1", 2014, 100, new BigDecimal(70.0), 201010, 0);
        Shareholder h4 = Shareholder.of("name4", "HF1", 2014, 50, new BigDecimal(30.0), 201010, 0);

        return new Shareholders(Arrays.asList(h1, h2, h3, h4));
    }
}