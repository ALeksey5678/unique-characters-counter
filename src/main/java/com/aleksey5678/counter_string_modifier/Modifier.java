package com.aleksey5678.counter_string_modifier;

import java.util.Map;

public class Modifier {
    public String modify(Map<Character, Integer> quantityOfUniqueSymbols) {
        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueSymbols.forEach((character, quantity) ->
                stringBuilder.append(String.format("%s - %s",character,quantity)).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
