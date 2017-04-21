package com.uzabase.shadow.util;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

/**
 * Collection Supporter includes all methods about supporting collection.
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
public interface CollectionSupporter<E> extends Iterable<E> {

    default Stream<E> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    default <R> Stream<R> map(Function<? super E, ? extends R> mapper) {
        return stream().map(mapper);
    }

    default <R> Stream<R> parallelMap(Function<? super E, ? extends R> mapper) {
        return stream().parallel().map(mapper);
    }

    default Optional<E> findFirst(Predicate<? super E> predicate) {
        return stream().filter(predicate).findFirst();
    }

    default <R> List<R> mapToList(Function<? super E, ? extends R> mapper) {
        return stream().map(mapper).collect(toList());
    }

    default <R> List<R> parallelMapToList(Function<? super E, ? extends R> mapper) {
        return parallelMap(mapper).collect(toList());
    }

    default <R> List<R> mapToList(Function2<? super E, ? extends R> mapper) {
        List<E> list = Lists.newArrayList(iterator());
        return IntStream.range(0, list.size()).mapToObj(i -> mapper.apply(i, list.get(i))).collect(toList());
    }

    default <R> Stream<R> flatMap(Function<? super E, ? extends Stream<? extends R>> mapper) {
        return stream().flatMap(mapper);
    }

    default <R> List<R> flatMapToList(Function<? super E, ? extends Stream<? extends R>> mapper) {
        return stream().flatMap(mapper).collect(toList());
    }

    default List<E> filterToList(Predicate<? super E> predicate) {
        return stream().filter(predicate).collect(toList());
    }

    default List<E> distinctElement() {
        return stream().distinct().collect(toList());
    }

    default boolean allMatch(Predicate<? super E> predicate) {
        return stream().allMatch(predicate);
    }

    default List<E> allOrEmpty(Predicate<? super E> predicate) {
        if (allMatch(predicate)) {
            return stream().collect(toList());
        }
        return Collections.emptyList();
    }

    default Optional<E> findFirst() {
        return stream().findFirst();
    }

    default boolean anyMatch(Predicate<? super E> predicate) {
        return stream().anyMatch(predicate);
    }

    default List<E> join(Iterable<E> target) {
        return Lists.newArrayList(Iterables.concat(Lists.newArrayList(iterator()), target));
    }

    default boolean isEmpty() {
        return !isNotEmpty();
    }

    default boolean isNotEmpty() {
        return stream().findAny().isPresent();
    }

    default boolean contains(E element) {
        return stream().anyMatch(e -> e.equals(element));
    }
}
