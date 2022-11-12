package com.aleksey5678.counter_string_modifier;

import com.aleksey5678.cache.Cache;
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
    private Modifier modifierMock;
    @Mock
    private Cache cacheMock;

    @InjectMocks
   private CachingUniqueCharactersCounter cachingUniqueCharactersCounter;

    private final String ourSentence = "a";
    private final String expected = "a - 1";

    @Test
    void shouldUseCashedValueOnlyIfKeyIsInCache() {
        when(cacheMock.isKeyHere(ourSentence)).thenReturn(true);
        when(cacheMock.getCachedValue(ourSentence)).thenReturn(expected);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(ourSentence);

        assertEquals(expected, result);
        verify(modifierMock, never()).modify(anyMap());
        verify(uniqueCharactersCounterMock, never()).showUniqueSymbolsAndTheirQuantity(ourSentence);
        verify(cacheMock, never()).putInCache(ourSentence, expected);
    }

    @Test
    void shouldCalculateAndPutInCacheIfKeyIsNotCached() {
        when(cacheMock.isKeyHere(ourSentence)).thenReturn(false);
        when(modifierMock.modify(anyMap())).thenReturn(expected);

        String result = cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(ourSentence);

        assertEquals(expected, result);
        verify(cacheMock).putInCache(ourSentence, result);
        verify(uniqueCharactersCounterMock).showUniqueSymbolsAndTheirQuantity(ourSentence);
        verify(cacheMock, never()).getCachedValue(ourSentence);
    }
}