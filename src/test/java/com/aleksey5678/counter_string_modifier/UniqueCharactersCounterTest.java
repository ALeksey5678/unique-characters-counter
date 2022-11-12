package com.aleksey5678.counter_string_modifier;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharactersCounterTest {
    private final UniqueCharactersCounter uniqueCharactersCounter = new UniqueCharactersCounter();

    @Test
    void shouldReturnUniqueSymbolsAndTheirQuantity() {
        String ourSentence = "ab";
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('b', 1);

        Map<Character, Integer> actual = uniqueCharactersCounter.showUniqueSymbolsAndTheirQuantity(ourSentence);

        assertEquals(map, actual);
    }
}