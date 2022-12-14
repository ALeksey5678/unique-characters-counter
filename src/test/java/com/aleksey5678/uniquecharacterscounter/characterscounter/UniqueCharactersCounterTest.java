package com.aleksey5678.uniquecharacterscounter.characterscounter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UniqueCharactersCounterTest {
    private final UniqueCharactersCounter uniqueCharactersCounter = new UniqueCharactersCounter();

    @Test
    void shouldReturnUniqueSymbolsAndTheirQuantity() {
        String sentence = "ababcb";
        Map<Character, Integer> expectedQuantityOfSymbolsRepetitionsBySymbol = new HashMap<>();
        expectedQuantityOfSymbolsRepetitionsBySymbol.put('a', 2);
        expectedQuantityOfSymbolsRepetitionsBySymbol.put('b', 3);
        expectedQuantityOfSymbolsRepetitionsBySymbol.put('c', 1);

        Map<Character, Integer> actualQuantityOfSymbolsRepetitionsBySymbol =
                uniqueCharactersCounter.calculateUniqueCharactersAndTheirQuantity(sentence);

        assertEquals(expectedQuantityOfSymbolsRepetitionsBySymbol, actualQuantityOfSymbolsRepetitionsBySymbol);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIfParameterIsNull() {
        String expectedMessageIfSentenceIsNull = "sentence can`t be Null";

        String message = assertThrows(IllegalArgumentException.class,
                () -> uniqueCharactersCounter.calculateUniqueCharactersAndTheirQuantity(null)).getMessage();

        assertEquals(expectedMessageIfSentenceIsNull, message);
    }

}