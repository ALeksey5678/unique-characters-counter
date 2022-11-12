package com.aleksey5678.cache;

import java.util.Map;

public class Cache {
  private final Map<String, String> cacheStorage;

    public Cache(Map<String, String> cacheStorage) {
        this.cacheStorage = cacheStorage;
    }

    public boolean isKeyHere(String ourSentence) {
        return cacheStorage.containsKey(ourSentence);
    }

    public String getCachedValue(String ourSentence) {
        return cacheStorage.get(ourSentence);
    }

    public void putInCache(String ourSentence, String resultOfCalculations) {
        cacheStorage.put(ourSentence, resultOfCalculations);
    }
}
