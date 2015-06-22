package com.company;

import java.util.Hashtable;
import java.util.Scanner;
/**
 * Created by imusiievych on 5/15/15.
 */
public class NumberOfLetterInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter some string");

        String userInput = input.nextLine();
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();

        ht.put(userInput.charAt(0), 1);

        for (int i = 1; i < userInput.length(); i++){
            if (ht.keySet().contains(userInput.charAt(i))){
                ht.put(userInput.charAt(i), ht.get(userInput.charAt(i))+1);
                System.out.println("i = " + i + " For the key: " + userInput.charAt(i) + " the value is " + ht.get(userInput.charAt(i)));
            }
            else {
                ht.put(userInput.charAt(i), 1);
                System.out.println(userInput.charAt(i) + " = " + ht.get(userInput.charAt(i)));
            }
        }
        System.out.println(ht);
    }
}
