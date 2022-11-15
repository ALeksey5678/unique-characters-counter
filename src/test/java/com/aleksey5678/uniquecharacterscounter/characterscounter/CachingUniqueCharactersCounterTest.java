package com.aleksey5678.uniquecharacterscounter.characterscounter;

import com.aleksey5678.characterscounter.cache.CalculationResultCache;
import com.aleksey5678.characterscounter.stringmodifier.MapToStringModifier;
import com.aleksey5678.characterscounter.characterscounter.CachingUniqueCharactersCounter;
import com.aleksey5678.characterscounter.characterscounter.UniqueCharactersCounter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CachingUniqueCharactersCounterTest {
    @Mock
    private UniqueCharactersCounter uniqueCharactersCounterMock;
    @Mock
    private MapToStringModifier mapToStringModifierMock;
    @Mock
    private CalculationResultCache calculationResultCacheMock;

    @InjectMocks
   private CachingUniqueCharactersCounter cachingUniqueCharactersCounter;

    private final String sentence = "a";
    private final String expected = "a - 1";

    @Test
    void shouldUseCashedValueOnlyIfKeyIsInCache() {
        when(calculationResultCacheMock.isCached(sentence)).thenReturn(true);
        when(calculationResultCacheMock.getCachedValue(sentence)).thenReturn(expected);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(sentence);

        assertEquals(expected, result);
        verify(mapToStringModifierMock, never()).modify(anyMap());
        verify(uniqueCharactersCounterMock, never()).calculateUniqueSymbolsAndTheirQuantity(sentence);
        verify(calculationResultCacheMock, never()).save(sentence, expected);
    }

    @Test
    void shouldCalculateAndPutInCacheIfKeyIsNotCached() {
        when(calculationResultCacheMock.isCached(sentence)).thenReturn(false);
        when(mapToStringModifierMock.modify(anyMap())).thenReturn(expected);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(sentence);

        assertEquals(expected, result);
        verify(calculationResultCacheMock).save(sentence, result);
        verify(uniqueCharactersCounterMock).calculateUniqueSymbolsAndTheirQuantity(sentence);
        verify(calculationResultCacheMock, never()).getCachedValue(sentence);
    }
}