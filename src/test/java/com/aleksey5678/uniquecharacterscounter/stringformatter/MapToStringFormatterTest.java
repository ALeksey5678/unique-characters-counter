package com.aleksey5678.uniquecharacterscounter.stringformatter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapToStringFormatterTest {
    private final MapToStringFormatter mapToStringFormatter = new MapToStringFormatter();

    @Test
    void shouldModifyQuantityOfSymbolRepetitions() {
        String expectedResult = "a - 1";

        Map<Character, Integer> quantityOfSymbolRepetitionsBySymbol = new HashMap<>();
        quantityOfSymbolRepetitionsBySymbol.put('a', 1);

        String modify = mapToStringFormatter.formattingMapToString(quantityOfSymbolRepetitionsBySymbol);

        assertEquals(expectedResult, modify);
    }

    @Test
    void returnNullPointerExceptionIfParameterIsNull() {
        String message = assertThrows(IllegalArgumentException.class,
                () -> mapToStringFormatter.formattingMapToString(null)).getMessage();
        String expectedMessageIfMapIsNull = "quantityOfUniqueCharactersByCharacter can`t be Null";

        assertEquals(expectedMessageIfMapIsNull, message);
    }
}
