package com.aleksey5678.counter;

import java.util.Map;

public class OutputFormatter {
    public String modify(Map<Character, Integer> quantityOfUniqueSymbols) {//rename
        StringBuilder stringBuilder = new StringBuilder();
        quantityOfUniqueSymbols.forEach((character, quantity) ->
                stringBuilder.append(String.format("%s - %s",character,quantity)).append(System.lineSeparator()));;//StringFormat
        return stringBuilder.toString();
    }
}
