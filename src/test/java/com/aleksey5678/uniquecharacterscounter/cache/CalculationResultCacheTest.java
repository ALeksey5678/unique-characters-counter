package com.aleksey5678.uniquecharacterscounter.cache;

import com.aleksey5678.characterscounter.cache.CalculationResultCache;
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
class CalculationResultCacheTest {
    @Mock
    private Map<String, String> resultOfCalculationsBySentenceMock;

    @InjectMocks
    CalculationResultCache newCalculationResultCache;
    private final String sentence = "a";
    private final String resultOfCalculations = "a - 1";

    @Test
    void shouldReturnTrueIfCached() {
        when(resultOfCalculationsBySentenceMock.containsKey(sentence)).thenReturn(true);

        boolean cached = newCalculationResultCache.isCached(sentence);

        assertTrue(cached);
    }

    @Test
    void shouldReturnCachedValueIfKeyIsInCache() {
        when(resultOfCalculationsBySentenceMock.get(sentence)).thenReturn(resultOfCalculations);

        String cachedValue = newCalculationResultCache.getCachedValue(sentence);

        assertEquals(resultOfCalculations, cachedValue);
    }

    @Test
    void shouldPutKeyAndValueInCache() {
        newCalculationResultCache.save(sentence, resultOfCalculations);
        verify(resultOfCalculationsBySentenceMock).put(sentence, resultOfCalculations);
    }
}