package com.aleksey5678.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CacheTest {
    @Mock
    private Map<String, String> storageMock;

    @InjectMocks
    Cache newCache;
    private final String ourSentence = "a";
    private final String resultOfCalculations = "a - 1";

    @Test
    void shouldReturnTrueIfKeyIsHere() {
        when(storageMock.containsKey(ourSentence)).thenReturn(true);

        boolean isHere = newCache.isKeyHere(ourSentence);

        assertTrue(isHere);
    }

    @Test
    void shouldReturnCachedValueIfKeyIsInCache() {
        when(storageMock.get(ourSentence)).thenReturn(resultOfCalculations);

        String cachedValue = newCache.getCachedValue(ourSentence);

        assertEquals(resultOfCalculations, cachedValue);
    }

    @Test
    void shouldPutKeyAndValueInCache() {
        newCache.putInCache(ourSentence, resultOfCalculations);
        verify(storageMock).put(ourSentence, resultOfCalculations);
    }
}