package com.aleksey5678.uniquecharacterscounter.stringmodifier;

import com.aleksey5678.characterscounter.stringmodifier.MapToStringModifier;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapToStringModifierTest {

    @Test
    void shouldModifyValue() {
        String expectedResult = "a - 1";

        Map<Character, Integer> quantityOfSymbolsRepetitionsBySymbol = new HashMap<>();
        quantityOfSymbolsRepetitionsBySymbol.put('a', 1);
        MapToStringModifier mapToStringModifier = new MapToStringModifier();

        String modify = mapToStringModifier.modify(quantityOfSymbolsRepetitionsBySymbol);

        assertEquals(expectedResult, modify);

    }
}