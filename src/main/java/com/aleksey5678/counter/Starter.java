//many packages
package com.aleksey5678.counter;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        CountUniqueCharacters countUniqueCharacters = new CountUniqueCharacters();
        OutputFormatter outputFormatter = new OutputFormatter();
        Cache cache=new Cache(new HashMap<>());
        String ourSentence;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your sentence,to exit press Q");
            ourSentence = scanner.nextLine();
            System.out.println("You have entered " + ourSentence);
            if (cache.isKeyHere(ourSentence)) {
                System.out.println(ourSentence+" contains in cache");
                String cachedResultOfCalculations = cache.getCachedValue(ourSentence);
                System.out.println(cachedResultOfCalculations);
            } else {
                String resultOfCalculations = outputFormatter.modify(countUniqueCharacters.count(ourSentence));
                cache.putInCache(ourSentence, resultOfCalculations);
                System.out.println(resultOfCalculations);
            }
        }
        while (!ourSentence.equals("Q"));
    }
}