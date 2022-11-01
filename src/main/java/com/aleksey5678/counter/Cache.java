package com.aleksey5678.counter;

import java.util.Map;

public class Cache {
  private final Map<String, String> storage;

    public Cache(Map<String, String> storage) {
        this.storage = storage;
    }

    public boolean isKeyHere(String ourSentence) {
        return storage.containsKey(ourSentence);
    }

    public String getCachedValue(String ourSentence) {
        return storage.get(ourSentence);
    }

    public void putInCache(String ourSentence, String resultOfCalculations) {
        storage.put(ourSentence, resultOfCalculations);
    }
}
