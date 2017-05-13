package com.uzabase.shadow;

import com.uzabase.shadow.cache.CacheDuration;
import com.uzabase.shadow.cache.CacheExpiryFactory;
import com.uzabase.shadow.cache.CacheName;
import com.uzabase.shadow.shareholders.Shareholder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.inject.Inject;
import java.util.Optional;

/**
 * Contents API application to run project
 * <p>
 * Created by Trung-Vu on 2017/05/01.
 */
@SpringBootApplication
@Import(JpaConfiguration.class)
@EntityScan(basePackages = {"com.uzabase.shadow.entity.common.speeda"})
@EnableCaching
public class ContentsApiApplication {

    @Inject
    private CacheDuration duration;

    public static void main(String[] args) {
        SpringApplication.run(ContentsApiApplication.class, args);
    }

    @Bean
    public JCacheCacheManager cacheManager() {
        CacheManager cacheManager = Caching.getCachingProvider().getCacheManager();
        cacheManager.createCache(CacheName.SHAREHOLDERS, this.<GlobalId, Shareholder>create());

        return new JCacheCacheManager(cacheManager);
    }

    private <X, Y> MutableConfiguration<X, Y> create() {
        return new MutableConfiguration<X, Y>().setExpiryPolicyFactory(
                new CacheExpiryFactory(
                        Optional.ofNullable(duration.getDuration()))).setStoreByValue(false);
    }
}
