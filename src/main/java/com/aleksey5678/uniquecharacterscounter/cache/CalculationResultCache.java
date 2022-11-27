package com.aleksey5678.uniquecharacterscounter.cache;

import java.util.Map;

public class CalculationResultCache {
    private final Map<String, String> resultOfCalculationsBySentence;

    public CalculationResultCache(Map<String, String> resultOfCalculationsBySentence) {
        this.resultOfCalculationsBySentence = resultOfCalculationsBySentence;
    }

    public boolean isCached(String sentence) {
        return resultOfCalculationsBySentence.containsKey(sentence);
    }

    public String getCachedValue(String sentence) {
        return resultOfCalculationsBySentence.get(sentence);
    }

    public void save(String sentence, String resultOfCalculations) {
        resultOfCalculationsBySentence.put(sentence, resultOfCalculations);
    }
}
