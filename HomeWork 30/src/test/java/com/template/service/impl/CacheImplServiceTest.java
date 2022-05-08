package com.template.service.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheImplServiceTest {
    CacheImplService cacheImplService = new CacheImplService();


    @Test
    void createCache() {
        cacheImplService.createCache("cache");
        assertTrue(cacheImplService.isCacheExist("cache"),"true");
    }

    @Test
    void put() {

        boolean test =  cacheImplService.put("1","1","1");
        assertTrue(test,"true");
    }

    @Test
    void get() {
        cacheImplService.put("1","1","1");
        assertEquals(cacheImplService.get("1","1"),"1");
    }

    @Test
    void clear() {
        cacheImplService.put("1","1","1");
        cacheImplService.clear();
        assertFalse(cacheImplService.isCacheExist("1"),"false");
    }

    @Test
    void testClear() {
        cacheImplService.put("1","1","1");
        cacheImplService.put("2","1","1");
        cacheImplService.clear("1");
        assertFalse(cacheImplService.isCacheExist("1"),"false");
    }

    @Test
    void isCacheExist() {
        cacheImplService.put("1","1","1");
        cacheImplService.put("2","1","1");
        assertTrue(cacheImplService.isCacheExist("2"),"true");
    }
}