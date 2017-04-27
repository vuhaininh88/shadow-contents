package com.uzabase.shadow.util;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * String collection supporter
 * <p>
 * Created by Trung-Vu on 2017/04/27.
 */
public interface StringCollection<E extends HasStringValue> extends CollectionSupporter<E> {

    default String asCommaSeparated() {
        return String.join(",", mapToList(E::getStringValue));
    }

    default String[] toArray() {
        return stream().map(E::getStringValue).toArray(String[]::new);
    }

    default List<String> toStringValueList() {
        return stream().map(E::getStringValue).collect(Collectors.toList());
    }

    default List<String> filter(Predicate<? super String> predicate) {
        return toStringValueList().stream().filter(predicate).collect(toList());
    }
}
