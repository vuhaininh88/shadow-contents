package com.uzabase.shadow.shareholders;

import com.uzabase.shadow.main.Name;
import com.uzabase.shadow.util.CollectionSupporter;
import lombok.Value;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Shareholders First Class Collection
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
@Value
public class Shareholders implements CollectionSupporter<Shareholder> {

    public static final Shareholders EMPTY = new Shareholders(Collections.emptyList());

    private List<Shareholder> shareholders;

    public Map<Name, List<Shareholder>> splitByName() {
        return stream().collect(Collectors.groupingBy(Shareholder::getName, LinkedHashMap::new, Collectors.mapping(Function.identity(), Collectors.toList())));
    }

    @Override
    public Iterator<Shareholder> iterator() {
        return shareholders.iterator();
    }
}
