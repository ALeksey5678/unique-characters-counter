package com.aleksey5678.characterscounter.main;

import com.aleksey5678.characterscounter.cache.CalculationResultCache;
import com.aleksey5678.characterscounter.characterscounter.CachingUniqueCharactersCounter;
import com.aleksey5678.characterscounter.characterscounter.UniqueCharactersCounter;
import com.aleksey5678.characterscounter.stringmodifier.MapToStringModifier;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        CachingUniqueCharactersCounter cachingUniqueCharactersCounter =
                new CachingUniqueCharactersCounter(new UniqueCharactersCounter(), new MapToStringModifier(),
                        new CalculationResultCache(new HashMap<>()));
        String sentence;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your sentence,to exit press Q");
            sentence = scanner.nextLine();
            System.out.println("You have entered " + sentence);
            System.out.println(cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(sentence));
        }
        while (!sentence.equals("Q"));
    }
}