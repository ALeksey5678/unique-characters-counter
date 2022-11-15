package com.aleksey5678.characterscounter.stringmodifier;

import java.util.Map;

public class MapToStringModifier {
    private static final String FORMATTING_PATTERN = "%s - %s";

    public String modify(Map<Character, Integer> quantityOfUniqueSymbols) {
        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueSymbols.forEach((character, quantity) ->
                stringBuilder.append(String.format(FORMATTING_PATTERN, character, quantity)).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
