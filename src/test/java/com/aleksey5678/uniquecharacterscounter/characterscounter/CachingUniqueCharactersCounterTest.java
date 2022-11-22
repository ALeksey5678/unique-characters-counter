package com.aleksey5678.uniquecharacterscounter.characterscounter;

import com.aleksey5678.uniquecharacterscounter.cache.CalculationResultCache;
import com.aleksey5678.uniquecharacterscounter.stringformatter.MapToStringFormatter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CachingUniqueCharactersCounterTest {
    @Mock
    private UniqueCharactersCounter uniqueCharactersCounter;
    @Mock
    private MapToStringFormatter mapToStringFormatter;
    @Mock
    private CalculationResultCache calculationResultCache;

    @InjectMocks
    private CachingUniqueCharactersCounter cachingUniqueCharactersCounter;

    private static final String SENTENCE = "a";
    private static final String EXPECTED_RESULT = "a - 1";
     private final static int WANTED_NUMBER_OF_INVOCATIONS = 1;

    @Test
    void shouldUseCashedValueOnlyIfKeyIsInCache() {
        when(calculationResultCache.isCached(SENTENCE)).thenReturn(true);
        when(calculationResultCache.getCachedValue(SENTENCE)).thenReturn(EXPECTED_RESULT);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(SENTENCE);

        assertEquals(EXPECTED_RESULT, result);
        verify(mapToStringFormatter, never()).formattingMapToString(anyMap());
        verify(uniqueCharactersCounter, never()).calculateUniqueCharactersAndTheirQuantity(SENTENCE);
        verify(calculationResultCache, never()).save(SENTENCE, EXPECTED_RESULT);
    }

    @Test
    void shouldCalculateAndPutInCacheIfKeyIsNotCached() {
        when(calculationResultCache.isCached(SENTENCE)).thenReturn(false);
        when(mapToStringFormatter.formattingMapToString(anyMap())).thenReturn(EXPECTED_RESULT);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(SENTENCE);

        assertEquals(EXPECTED_RESULT, result);

        verify(calculationResultCache,times(WANTED_NUMBER_OF_INVOCATIONS)).save(SENTENCE, result);
        verify(uniqueCharactersCounter,times(WANTED_NUMBER_OF_INVOCATIONS)).calculateUniqueCharactersAndTheirQuantity(SENTENCE);
        verify(calculationResultCache, never()).getCachedValue(SENTENCE);
    }
}