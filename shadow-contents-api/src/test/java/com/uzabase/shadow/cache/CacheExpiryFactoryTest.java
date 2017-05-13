package com.uzabase.shadow.cache;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Test;

import javax.cache.expiry.ExpiryPolicy;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Trung Vu on 2017/05/14.
 */
public class CacheExpiryFactoryTest {

    @Tested private CacheExpiryFactory factory;
    @Injectable private Optional<Integer> durationAmount;

    @Test
    public void createExpiryPolicyWithDuration() throws Exception {
        new Expectations() {{
            durationAmount.orElse(60); result = 70;
        }};

        ExpiryPolicy expiryPolicy = factory.create();
        assertThat(expiryPolicy.getExpiryForCreation().getTimeUnit(), is(TimeUnit.HOURS));
        assertThat(expiryPolicy.getExpiryForCreation().getDurationAmount(), is(70L));
    }
}