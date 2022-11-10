package com.aleksey5678.counter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OutputModifierTest {
  private final  String expectedResult = "a - 1";

    @Test
    void smt() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        OutputModifier outputModifier = new OutputModifier();

        String modify = outputModifier.modify(map);

        assertEquals(expectedResult, modify);

    }
}