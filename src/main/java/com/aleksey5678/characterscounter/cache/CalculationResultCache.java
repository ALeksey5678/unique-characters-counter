package com.aleksey5678.characterscounter.cache;

import java.util.Map;

public class CalculationResultCache {
  private final Map<String, String> stringMap;

    public CalculationResultCache(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public boolean isCached(String ourSentence) {
        return stringMap.containsKey(ourSentence);
    }

    public String getCachedValue(String ourSentence) {
        return stringMap.get(ourSentence);
    }

    public void save(String sentence, String resultOfCalculations) {
        stringMap.put(sentence, resultOfCalculations);
    }
}
