package com.aleksey5678.uniquecharacterscounter.stringformatter;

import java.util.Map;

public class MapToStringFormatter {
    private static final String FORMAT_PATTERN = "%s - %s";

    public String formatMapToString(Map<Character, Integer> quantityOfUniqueCharactersByCharacter) {

        if (quantityOfUniqueCharactersByCharacter == null) {
            throw new IllegalArgumentException ("quantityOfUniqueCharactersByCharacter can`t be Null");
        }

        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueCharactersByCharacter.forEach((character, quantity) ->
                stringBuilder.append(String.format(FORMAT_PATTERN, character, quantity)).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
