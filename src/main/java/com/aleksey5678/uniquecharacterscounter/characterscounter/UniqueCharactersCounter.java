package com.aleksey5678.uniquecharacterscounter.characterscounter;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersCounter {
    private static final int ONE = 1;

    public Map<Character, Integer> calculateUniqueCharactersAndTheirQuantity(String sentence) {

        if (sentence == null) {
            throw new IllegalArgumentException("sentence can`t be Null");
        }

        Map<Character, Integer> numberOfCharacterRepetitionsByUniqueCharacter = new HashMap<>();

        for (char character : sentence.toCharArray()) {
            numberOfCharacterRepetitionsByUniqueCharacter.computeIfPresent(character,
                    (symbol, integer) -> integer + ONE);

            numberOfCharacterRepetitionsByUniqueCharacter.putIfAbsent(character, ONE);
        }
        return numberOfCharacterRepetitionsByUniqueCharacter;
    }
}
