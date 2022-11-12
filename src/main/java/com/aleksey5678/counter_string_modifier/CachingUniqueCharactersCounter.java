package com.aleksey5678.counter_string_modifier;

import com.aleksey5678.cache.Cache;

public class CachingUniqueCharactersCounter {
    private final UniqueCharactersCounter uniqueCharactersCounter;
    private final Modifier modifier;
    private final Cache cache;

    public CachingUniqueCharactersCounter
            (UniqueCharactersCounter uniqueCharactersCounter, Modifier modifier, Cache cache) {
        this.uniqueCharactersCounter = uniqueCharactersCounter;
        this.modifier = modifier;
        this.cache = cache;
    }

    public String countUniqueCharactersOrGetFromCache(String ourSentence) {

        if (cache.isKeyHere(ourSentence)) {
            System.out.println(ourSentence + " contains in cache");
            return cache.getCachedValue(ourSentence);
        } else {
            String resultOfCalculations =
                    modifier.modify(uniqueCharactersCounter.showUniqueSymbolsAndTheirQuantity(ourSentence));
            cache.putInCache(ourSentence, resultOfCalculations);
            return resultOfCalculations;
        }
    }
}


