package com.aleksey5678.counter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CountUniqueCharactersTest {
    private final CountUniqueCharacters countUniqueCharacters = new CountUniqueCharacters();

    @Test
    void shouldReturnUniqueSymbolsAndTheirQuantity() {
        String ourSentence = "ab";
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);

        Map<Character, Integer> actual = countUniqueCharacters.showUniqueSymbolsAndTheirQuantity(ourSentence);

        assertEquals(map, actual);
    }
}