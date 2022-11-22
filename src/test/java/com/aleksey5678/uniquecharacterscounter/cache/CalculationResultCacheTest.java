package com.aleksey5678.uniquecharacterscounter.cache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculationResultCacheTest {
    @Mock
    private Map<String, String> resultOfCalculationsBySentence;

    @InjectMocks
    private CalculationResultCache calculationResultCache;

    private static final String SENTENCE = "a";
    private static final String EXPECTED_RESULT_OF_CALCULATIONS = "a - 1";
    private final static int WANTED_NUMBER_OF_INVOCATIONS = 1;


    @Test
    void shouldReturnTrueIfCached() {
        when(resultOfCalculationsBySentence.containsKey(SENTENCE)).thenReturn(true);

        boolean isCached = calculationResultCache.isCached(SENTENCE);

        assertTrue(isCached);
    }

    @Test
    void shouldReturnCachedValueIfKeyIsInCache() {
        when(resultOfCalculationsBySentence.get(SENTENCE)).thenReturn(EXPECTED_RESULT_OF_CALCULATIONS);

        String cachedValue = calculationResultCache.getCachedValue(SENTENCE);

        assertEquals(EXPECTED_RESULT_OF_CALCULATIONS, cachedValue);
    }

    @Test
    void shouldPutKeyAndValueInCache() {
        calculationResultCache.save(SENTENCE, EXPECTED_RESULT_OF_CALCULATIONS);
        verify(resultOfCalculationsBySentence, times(WANTED_NUMBER_OF_INVOCATIONS)).put(SENTENCE, EXPECTED_RESULT_OF_CALCULATIONS);
    }
}