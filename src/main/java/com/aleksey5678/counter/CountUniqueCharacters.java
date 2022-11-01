package com.aleksey5678.counter;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueCharacters {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    public Map<Character, Integer> count(String ourSentence) {//rename
       Map<Character, Integer> quantityOfUniqueSymbols = new HashMap<>();//rename

        for (int indexOfCharacter = ZERO; indexOfCharacter < ourSentence.length(); indexOfCharacter++) {
            char characters = ourSentence.charAt(indexOfCharacter);
            if (!quantityOfUniqueSymbols.containsKey(characters)) {
                quantityOfUniqueSymbols.put(characters, ONE);
            } else {
                Integer integer = quantityOfUniqueSymbols.get(characters);
                integer++;
                quantityOfUniqueSymbols.put(characters, integer);
            }
        }
        return quantityOfUniqueSymbols;
    }
}
