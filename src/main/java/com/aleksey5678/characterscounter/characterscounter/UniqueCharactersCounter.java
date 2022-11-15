package com.aleksey5678.characterscounter.characterscounter;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersCounter {
    private static final int ONE = 1;

    public Map<Character, Integer> calculateUniqueSymbolsAndTheirQuantity(String sentence) {

        Map<Character, Integer> numberOfCharacterRepetitionsByUniqueCharacter = new HashMap<>();
        for (char characters : sentence.toCharArray()) {
            numberOfCharacterRepetitionsByUniqueCharacter.computeIfPresent(characters, (character, integer) -> integer + ONE);
            numberOfCharacterRepetitionsByUniqueCharacter.putIfAbsent(characters, ONE);
        }
        return numberOfCharacterRepetitionsByUniqueCharacter;
    }
}
