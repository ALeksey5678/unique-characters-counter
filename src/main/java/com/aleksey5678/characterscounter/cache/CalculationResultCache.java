package com.aleksey5678.characterscounter.cache;

import java.util.Map;

public class CalculationResultCache {
  private final Map<String, String> resultOfCalculationsBySentence;

    public CalculationResultCache(Map<String, String> resultOfCalculationsBySentence) {
        this.resultOfCalculationsBySentence = resultOfCalculationsBySentence;
    }

    public boolean isCached(String ourSentence) {
        return resultOfCalculationsBySentence.containsKey(ourSentence);
    }

    public String getCachedValue(String ourSentence) {
        return resultOfCalculationsBySentence.get(ourSentence);
    }

    public void save(String sentence, String resultOfCalculations) {
        resultOfCalculationsBySentence.put(sentence, resultOfCalculations);
    }
}
