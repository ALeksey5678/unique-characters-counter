package com.aleksey5678.counter;

public class UnionOfMethods {
   private final CountUniqueCharacters countUniqueCharacters;
   private final OutputModifier outputModifier;
   private final Cache  cache;

    public UnionOfMethods(CountUniqueCharacters countUniqueCharacters, OutputModifier outputModifier, Cache cache) {
        this.countUniqueCharacters = countUniqueCharacters;
        this.outputModifier = outputModifier;
        this.cache = cache;
    }

    public String uniteAllMethods(String ourSentence) {

        if (cache.isKeyHere(ourSentence)) {
            System.out.println(ourSentence + " contains in cache");
            String cachedResultOfCalculations = cache.getCachedValue(ourSentence);
            return cachedResultOfCalculations;
        } else {
            String resultOfCalculations = outputModifier.modify(countUniqueCharacters.showUniqueSymbolsAndTheirQuantity(ourSentence));
            cache.putInCache(ourSentence, resultOfCalculations);
            return resultOfCalculations;
        }

    }
}


