package com.aleksey5678.main;

import com.aleksey5678.cache.Cache;
import com.aleksey5678.counter_string_modifier.CachingUniqueCharactersCounter;
import com.aleksey5678.counter_string_modifier.UniqueCharactersCounter;
import com.aleksey5678.counter_string_modifier.Modifier;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        CachingUniqueCharactersCounter cachingUniqueCharactersCounter = new CachingUniqueCharactersCounter(new UniqueCharactersCounter(), new Modifier(),
                new Cache(new HashMap<>()));
        String ourSentence;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your sentence,to exit press Q");
            ourSentence = scanner.nextLine();
            System.out.println("You have entered " + ourSentence);
            System.out.println( cachingUniqueCharactersCounter.countUniqueCharactersOrGetFromCache(ourSentence));
        }
        while (!ourSentence.equals("Q"));
    }
}