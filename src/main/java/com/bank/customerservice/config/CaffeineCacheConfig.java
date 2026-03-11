package com.bank.customerservice.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CaffeineCacheConfig {

    public static final String CUSTOMER_CACHE_NAME = "customer";

    @Bean
    public CacheManager cacheManager() {
        Caffeine<Object, Object> caffeine = Caffeine.newBuilder()
                .expireAfterAccess(15, TimeUnit.MINUTES)
                .maximumSize(100);

        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        //This is optional. If we don't setCacheNames here, spring create dynamically during runtime based on
        // @Cacheable(cacheNames = CUSTOMER_CACHE_NAME, key = "#custId")
        //instead of mixing everything together. create different region and save data to the region
        caffeineCacheManager.setCacheNames(List.of(CUSTOMER_CACHE_NAME, "account")); //Here this property disable dynamic creation
        caffeineCacheManager.setCaffeine(caffeine);
        return caffeineCacheManager;
    }

}
