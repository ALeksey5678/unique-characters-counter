package com.aleksey5678.counter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CacheTest {

    private final Map<String, String> mock = Mockito.mock(Map.class);

    Cache newCache = new Cache(mock);
    private final String ourSentence = "a";
    private final String resultOfCalculations = "a - 1";

    @Test
    void isKeyHere() {
        when(mock.containsKey(ourSentence)).thenReturn(true);

        boolean isHere = newCache.isKeyHere(ourSentence);

        assertTrue(isHere);
    }

    @Test
    void getCachedValue() {
        when(mock.get(ourSentence)).thenReturn(resultOfCalculations);

        String cachedValue = newCache.getCachedValue(ourSentence);

        assertEquals(resultOfCalculations, cachedValue);
    }

    @Test
    void putInCache() {
        newCache.putInCache(ourSentence, resultOfCalculations);
        verify(mock).put(ourSentence, resultOfCalculations);
    }
}