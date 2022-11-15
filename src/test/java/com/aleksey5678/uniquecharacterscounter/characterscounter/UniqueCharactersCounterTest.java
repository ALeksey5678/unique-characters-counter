package com.aleksey5678.uniquecharacterscounter.characterscounter;

import com.aleksey5678.characterscounter.characterscounter.UniqueCharactersCounter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniqueCharactersCounterTest {
    private final UniqueCharactersCounter uniqueCharactersCounter = new UniqueCharactersCounter();

    @Test
    void shouldReturnUniqueSymbolsAndTheirQuantity() {
        String sentence = "ababcb";
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 3);
        map.put('c', 1);

        Map<Character, Integer> actual = uniqueCharactersCounter.calculateUniqueSymbolsAndTheirQuantity(sentence);

        assertEquals(map, actual);
    }
}