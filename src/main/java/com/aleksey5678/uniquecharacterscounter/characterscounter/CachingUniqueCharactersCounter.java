package com.aleksey5678.uniquecharacterscounter.characterscounter;

import com.aleksey5678.uniquecharacterscounter.cache.CalculationResultCache;
import com.aleksey5678.uniquecharacterscounter.stringformatter.MapToStringFormatter;

public class CachingUniqueCharactersCounter {
    private final UniqueCharactersCounter uniqueCharactersCounter;
    private final MapToStringFormatter mapToStringFormatter;
    private final CalculationResultCache calculationResultCache;

    public CachingUniqueCharactersCounter(UniqueCharactersCounter uniqueCharactersCounter,
                                          MapToStringFormatter mapToStringFormatter,
                                          CalculationResultCache calculationResultCache) {
        this.uniqueCharactersCounter = uniqueCharactersCounter;
        this.mapToStringFormatter = mapToStringFormatter;
        this.calculationResultCache = calculationResultCache;
    }

    public String countUniqueCharactersOrGetFromCache(String sentence) {

        if (calculationResultCache.isCached(sentence)) {
            System.out.println(sentence + " contains in cache");
            return calculationResultCache.getCachedValue(sentence);
        } else {
            String resultOfCalculations =
                    mapToStringFormatter.formatMapToString(uniqueCharactersCounter.calculateUniqueCharactersAndTheirQuantity(sentence));
            calculationResultCache.save(sentence, resultOfCalculations);
            return resultOfCalculations;
        }
    }
}


