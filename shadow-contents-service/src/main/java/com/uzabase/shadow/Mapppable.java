package com.uzabase.shadow;

/**
 * Interface to map domain class to JSON class
 * <p>
 * Created by Trung-Vu on 2017/05/06.
 */
public interface Mapppable<F, T> {

    T map(F source);
}
