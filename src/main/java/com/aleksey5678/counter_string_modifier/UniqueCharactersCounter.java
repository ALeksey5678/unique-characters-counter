package com.aleksey5678.counter_string_modifier;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersCounter {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public Map<Character, Integer> showUniqueSymbolsAndTheirQuantity(String ourSentence) {

       Map<Character, Integer> storageOfUniqueSymbolsAndTheirQuantity = new HashMap<>();

        for (int indexOfCharacter = ZERO; indexOfCharacter < ourSentence.length(); indexOfCharacter++) {
            char characters = ourSentence.charAt(indexOfCharacter);
            if (!storageOfUniqueSymbolsAndTheirQuantity.containsKey(characters)) {
                storageOfUniqueSymbolsAndTheirQuantity.put(characters, ONE);
            } else {
                Integer quantityOfUniqueSymbols = storageOfUniqueSymbolsAndTheirQuantity.get(characters);
                quantityOfUniqueSymbols++;
                storageOfUniqueSymbolsAndTheirQuantity.put(characters, quantityOfUniqueSymbols);
            }
        }
        return storageOfUniqueSymbolsAndTheirQuantity;
    }
}
