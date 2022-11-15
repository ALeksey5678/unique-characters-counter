package com.aleksey5678.characterscounter.characterscounter;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersCounter {
    private static final int ONE = 1;

    public Map<Character, Integer> calculateUniqueSymbolsAndTheirQuantity(String sentence) {

        Map<Character, Integer> characterToInteger = new HashMap<>();
        for (char characters : sentence.toCharArray()) {
            characterToInteger.computeIfPresent(characters, (character, integer) -> integer+ONE);
            characterToInteger.putIfAbsent(characters, ONE);
        }
        return characterToInteger;
    }
}
