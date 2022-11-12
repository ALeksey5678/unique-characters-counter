package com.aleksey5678.counter_string_modifier;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ModifierTest {

    @Test
    void shouldModifyValue() {
        String expectedResult = "a - 1";

        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        Modifier modifier = new Modifier();

        String modify = modifier.modify(map);

        assertEquals(expectedResult, modify);

    }
}