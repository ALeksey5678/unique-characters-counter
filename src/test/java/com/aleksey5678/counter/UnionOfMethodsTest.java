package com.aleksey5678.counter;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UnionOfMethodsTest {
    private final CountUniqueCharacters countUniqueCharactersMock = Mockito.mock(CountUniqueCharacters.class);
    private final OutputModifier outputModifierMock = Mockito.mock((OutputModifier.class));
    private final Cache cacheMock = Mockito.mock(Cache.class);

    UnionOfMethods unionOfMethods = new UnionOfMethods(countUniqueCharactersMock, outputModifierMock, cacheMock);

    private final String ourSentence = "a";
    private final String expected = "a - 1";

    @Test
    void Should_Use_GetCashedValue_Method_Only_In_UnionOfMethods_Class_If_Key_Is_In_Cache() {
        when(cacheMock.isKeyHere(ourSentence)).thenReturn(true);
        when(cacheMock.getCachedValue(ourSentence)).thenReturn(expected);

        String result = unionOfMethods.uniteAllMethods(ourSentence);
        assertEquals(expected, result);

        verify(outputModifierMock, never()).modify(anyMap());

        verify(countUniqueCharactersMock, never()).showUniqueSymbolsAndTheirQuantity(ourSentence);

        verify(cacheMock, never()).putInCache(ourSentence, expected);
    }

    @Test
    void Should_Use_All_Methods_Except_GetCashedValue_In_UnionOfMethods_Class_If_Key_Is_Not_In_Cache() {
        when(cacheMock.isKeyHere(ourSentence)).thenReturn(false);
        when(outputModifierMock.modify(anyMap())).thenReturn(expected);

        String result = unionOfMethods.uniteAllMethods(ourSentence);
        assertEquals(expected, result);

        verify(cacheMock).putInCache(ourSentence, result);

        verify(countUniqueCharactersMock).showUniqueSymbolsAndTheirQuantity(ourSentence);

        verify(cacheMock, never()).getCachedValue(ourSentence);
    }
}