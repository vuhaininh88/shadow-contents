package com.uzabase.shadow.util;

/**
 * Function2 class to support apply method
 * <p>
 * Created by Trung-Vu on 2017/04/21.
 */
public interface Function2<F, R> {

    R apply(Integer index, F f);
}
