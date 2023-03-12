package com.github.zipcodewilmington;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("Guess a word!");
        Scanner scanner = new Scanner(new File("/Users/jarek/Projects/WordGuess/input.txt"));
        Scanner keyScanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        boolean playAgain = true;
        while(playAgain) {
            Random random = new Random();
            String word = words.get(random.nextInt(words.size()));
            List<Character> playerGuesses = new ArrayList<>();
            int wrongCount = 0;

            while (true) {
                printMan(wrongCount);
                if (wrongCount >= 6) {
                    System.out.println("You lose");
                    System.out.println("Answer: " + word);
                    break;
                }
                printWordState(word, playerGuesses);
                if (!getPlayerGuess(keyScanner, word, playerGuesses)) {
                    wrongCount++;
                }

                if (printWordState(word, playerGuesses)) {
                    System.out.println("You Won!");
                    break;
                } else {
                    System.out.println("Nope try again");
                }

                if (wrongCount == 6) {
                    System.out.println("Want to guess the word?");
                    if (keyScanner.nextLine().equals(word)) {
                        System.out.println("You Won!");
                        break;
                    } else {
                        System.out.println("You lose.");
                    }
                }
            }
            System.out.println("Want to play again?(y/n");
            String playAgainInput = keyScanner.nextLine();
            if (!playAgainInput.equals("y")) {
                playAgain = false;
            }
        }

    }

private static void printMan(Integer wrongCount){
            System.out.println("______");
            System.out.println(" |");
            if (wrongCount >= 1) {
                System.out.println(" O");
            }
            if (wrongCount >= 2) {
                System.out.print("\\ ");
                if (wrongCount >= 3) {
                    System.out.println("/");
                }
                else {
                    System.out.println("");
                }
            }
            if (wrongCount >= 4) {
                System.out.println(" |");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
                if (wrongCount >= 6) {
                    System.out.println("\\");
                }
                else {
                    System.out.println("");
                }
            }
            System.out.println("");
            System.out.println("");
        }
    private static boolean getPlayerGuess(Scanner keyScanner, String word, List<Character> playerGuesses) {
        System.out.println("Enter a letter");
        String letterGuess = keyScanner.nextLine();
        playerGuesses.add(letterGuess.charAt(0));

        return word.contains(letterGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        int correctCount = 0;
        for(int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctCount++;
            }
            else {
                System.out.print("-");
            }
        }
        System.out.println();

        return (word.length() == correctCount);
    }
}
