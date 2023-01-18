package com.transsaction.mpesa.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Joseph Kibe
 * Created on Friday, April 22, 2022
 * Time 5:23 PM
 */

@Component
public class AppCache {
    private static Cache<String, Object> TRANSACTION_CACHE;

    HashMap<String, Object> onHoldTxn = new HashMap<>();

    AppCache() {
        onHoldTxn.put("test", "Test 1");
        onHoldTxn.put("test1", "Test 1");
        onHoldTxn.put("test3", "Test 1");

        TRANSACTION_CACHE = CacheBuilder
                .newBuilder()
                .maximumSize(10)
                .expireAfterWrite(Duration.ofMillis(100000))
                .concurrencyLevel(1)
                .removalListener(
                        new RemovalListener<String, Object>() {
                            @Override
                            public void onRemoval(RemovalNotification<String, Object> removalNotification) {
                                processTheAwaitingTxn(removalNotification.getKey());
                                System.out.println(removalNotification.getCause());
                            }
                        }
                )
                .build();

        TRANSACTION_CACHE.put("test", "Test 1");
        TRANSACTION_CACHE.put("test1", "Test 1");
        TRANSACTION_CACHE.put("test3", "Test 1");
        TRANSACTION_CACHE.put("test4", "Test 1");
        TRANSACTION_CACHE.put("test5", "Test 1");
        TRANSACTION_CACHE.put("test6", "Test 1");

        System.out.println(TRANSACTION_CACHE.size());
        TRANSACTION_CACHE.invalidate("test1");

    }

    public void addToCache(String key, String object) {
        TRANSACTION_CACHE.put(key, object);
    }

    public void evictFromCache(String key) {
        TRANSACTION_CACHE.invalidate(key);
    }

    public boolean isItemExiting(String key, Object objectHold) {
        if (TRANSACTION_CACHE.getIfPresent(key) == null) {
            onHoldTxn.put(key, objectHold);
            System.out.println(TRANSACTION_CACHE.size());
            return false;
        }
        return true;
    }

    private void processTheAwaitingTxn(String key) {
        // If object has one of those keys
        // Proceed to Business rule

        System.out.println("Heading to business rule >>>> " + key);
        Object str = onHoldTxn.get(key);
        System.out.println(onHoldTxn.size());
        System.out.println(str);
        onHoldTxn.remove(key);
        System.out.println(onHoldTxn.size());
    }
}
