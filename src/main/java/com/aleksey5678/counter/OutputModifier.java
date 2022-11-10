package com.aleksey5678.counter;

import java.util.Map;

public class OutputModifier {
    public String modify(Map<Character, Integer> quantityOfUniqueSymbols) {
        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueSymbols.forEach((character, quantity) ->
                stringBuilder.append(String.format("%s - %s",character,quantity)).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
