package com.aleksey5678.uniquecharacterscounter.characterscounter;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharactersCounter {
    private static final int ONE = 1;

    public Map<Character, Integer> calculateUniqueCharactersAndTheirQuantity(String sentence) {

        if (sentence == null) {
            throw new NullPointerException("parameter can`t be Null");
        }

        Map<Character, Integer> numberOfCharacterRepetitionsByUniqueCharacter = new HashMap<>();

        for (char characters : sentence.toCharArray()) {
            numberOfCharacterRepetitionsByUniqueCharacter.computeIfPresent(characters,
                    (character, integer) -> integer + ONE);

            numberOfCharacterRepetitionsByUniqueCharacter.putIfAbsent(characters, ONE);
        }
        return numberOfCharacterRepetitionsByUniqueCharacter;
    }
}
