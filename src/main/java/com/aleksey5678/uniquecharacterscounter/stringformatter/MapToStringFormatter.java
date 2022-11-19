package com.aleksey5678.uniquecharacterscounter.stringformatter;

import java.util.Map;

public class MapToStringFormatter {
    private static final String FORMATTING_PATTERN = "%s - %s";

    public String formattingMapToString(Map<Character, Integer> quantityOfUniqueCharactersByCharacter) {

        if (quantityOfUniqueCharactersByCharacter == null) {
            throw new NullPointerException("parameter can`t be Null");
        }

        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueCharactersByCharacter.forEach((character, quantity) ->
                stringBuilder.append(String.format(FORMATTING_PATTERN, character, quantity)).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
