//many packages
package com.aleksey5678.counter;

import java.util.HashMap;
import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        UnionOfMethods unionOfMethods = new UnionOfMethods(new CountUniqueCharacters(), new OutputModifier(),
                new Cache(new HashMap<>()));
        String ourSentence;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your sentence,to exit press Q");
            ourSentence = scanner.nextLine();
            System.out.println("You have entered " + ourSentence);
            System.out.println( unionOfMethods.uniteAllMethods(ourSentence));
        }
        while (!ourSentence.equals("Q"));
    }
}