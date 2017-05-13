package com.uzabase.shadow.cache;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.cache.configuration.Factory;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ExpiryPolicy;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Cache Expiry Factory to create expiry policy caching
 * <p>
 * Created by Trung Vu on 2017/05/13.
 */
@AllArgsConstructor
@Value
public class CacheExpiryFactory implements Factory<ExpiryPolicy> {

    private Optional<Integer> durationAmount;

    @Override
    public ExpiryPolicy create() {
        return new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, durationAmount.orElse(60)));
    }
}
