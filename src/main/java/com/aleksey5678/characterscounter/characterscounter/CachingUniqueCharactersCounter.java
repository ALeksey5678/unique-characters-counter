package com.aleksey5678.characterscounter.characterscounter;

import com.aleksey5678.characterscounter.cache.CalculationResultCache;
import com.aleksey5678.characterscounter.stringmodifier.MapToStringModifier;

public class CachingUniqueCharactersCounter {
    private final UniqueCharactersCounter uniqueCharactersCounter;
    private final MapToStringModifier mapToStringModifier;
    private final CalculationResultCache calculationResultCache;

    public CachingUniqueCharactersCounter
            (UniqueCharactersCounter uniqueCharactersCounter, MapToStringModifier mapToStringModifier, CalculationResultCache calculationResultCache) {
        this.uniqueCharactersCounter = uniqueCharactersCounter;
        this.mapToStringModifier = mapToStringModifier;
        this.calculationResultCache = calculationResultCache;
    }

    public String countUniqueCharactersOrGetFromCache(String sentence) {

        if (calculationResultCache.isCached(sentence)) {
            System.out.println(sentence + " contains in cache");
            return calculationResultCache.getCachedValue(sentence);
        } else {
            String resultOfCalculations =
                    mapToStringModifier.modify(uniqueCharactersCounter.calculateUniqueSymbolsAndTheirQuantity(sentence));
            calculationResultCache.save(sentence, resultOfCalculations);
            return resultOfCalculations;
        }
    }
}


