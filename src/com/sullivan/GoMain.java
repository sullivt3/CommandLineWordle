package com.sullivan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoMain {

    static ArrayList<Character> notUsed = new ArrayList<Character>();
    static ArrayList<Character> rightSpot = new ArrayList<Character>();
    static ArrayList<Character> inWord = new ArrayList<Character>();
    static ArrayList<String> guessedWords = new ArrayList<String>();
    static String clearScreen = "\003[H\003[2J";

    public static void main(String arg[]) throws IOException {

        String word = "cheap";
        // ArrayList<Character> notUsed = new ArrayList();
        char[] wordArr = word.toCharArray();
        int guesses = 0;
        Scanner reader;
        boolean validGuess;
        while (guesses < 6) {
            // clearTerm();
            keyboard();
            System.out.println();
            validGuess = true;
            reader = new Scanner(System.in);
            System.out.print("> ");
            String guess = reader.next();
            if (containsWord(guess) == false) {
                System.out.println("Invalid word, Please enter a valid guess");
                validGuess = false;
            } else if (guess.length() != 5 || guess.isEmpty()) {
                System.out.println("Invalid guess, only " + guess.length()
                        + " characters! Try again.");
                validGuess = false;
            } else if (word.equals(guess)) {
                System.out.println("Correct!");
                break;
            } else {
                guessedWords.add(guess);
                char[] guessArr = guess.toCharArray();

                for (int i = 0; i < guessArr.length; i++) {
                    String tmp = String.valueOf(guessArr[i]);
                    if (word.indexOf(guessArr[i]) == -1) {
                        // System.out.println("nah it aint in here");
                        if (notUsed.contains(guessArr[i]) == false) {
                            notUsed.add(guessArr[i]);
                        }
                    } else if (word.contains(tmp)) {
                        if (guessArr[i] == wordArr[i]) {
                            // System.out.println(guessArr[i] +
                            // " is in the correct spot");
                            rightSpot.add(guessArr[i]);
                        } else {
                            // System.out.println(guessArr[i] +
                            // " is in the word, not this spot");
                            inWord.add(guessArr[i]);
                        }
                    }
                }

                if (validGuess = true) {
                    guesses++;
                }
                // System.out.println("Guessed but not Used " +
                // notUsed.toString());
            }
        }
    }

    boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    static boolean containsWord(String s) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(
                "AA.txt"));
        String st;
        while ((st = br.readLine()) != null) { // final String lineFromFile =
            // scanner.nextLine();
            if (st.contains(s)) {
                return true;
            }
        }
        return false;
    }

    static void keyboard() {
        String reset = "\u001B[0m";
        String greenText = "\u001B[32m";
        String yellowText = "\u001B[33m";
        String greenBG = "\u001B[42m";
        String yellowBG = "\u001B[43m";
        String whiteBG = "\u001B[47m";
        String black = "\u001B[30m";
        String boldOn = "\033[0;1m";
        String boldOff = "\033[0m";
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        char[] row1Arr = row1.toCharArray();
        for (int i = 0; i < row1Arr.length; i++) {
            if (notUsed.contains(row1Arr[i]) == true) {
                System.out.print(boldOff + row1Arr[i] + reset + " ");
            } else if (rightSpot.contains(row1Arr[i]) == true) {
                System.out.print(greenBG + row1Arr[i] + reset + " ");
            } else if (inWord.contains(row1Arr[i]) == true) {
                System.out.print(yellowBG + row1Arr[i] + reset + " ");
            } else {
                System.out.print(boldOn + row1Arr[i] + reset + " ");
            }
        }
        System.out.println(reset);
        char[] row2Arr = row2.toCharArray();
        for (int i = 0; i < row2Arr.length; i++) {
            if (notUsed.contains(row2Arr[i]) == true) {
                System.out.print(boldOff + row2Arr[i] + reset + " ");
            } else if (rightSpot.contains(row2Arr[i]) == true) {
                System.out.print(greenBG + row2Arr[i] + reset + " ");
            } else if (inWord.contains(row2Arr[i]) == true) {
                System.out.print(yellowBG + row2Arr[i] + reset + " ");
            } else {
                System.out.print(boldOn + row2Arr[i] + reset + " ");
            }
        }
        System.out.println(reset);
        char[] row3Arr = row3.toCharArray();
        for (int i = 0; i < row3Arr.length; i++) {
            if (notUsed.contains(row3Arr[i]) == true) {
                System.out.print(boldOff + row3Arr[i] + reset + " ");
            } else if (rightSpot.contains(row3Arr[i]) == true) {
                System.out.print(greenBG + row3Arr[i] + reset + " ");
            } else if (inWord.contains(row3Arr[i]) == true) {
                System.out.print(yellowBG + row3Arr[i] + reset + " ");
            } else {
                System.out.print(boldOn + row3Arr[i] + reset + " ");
            }
        }
    }

    static void clearTerm() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (final Exception e) {

        }

    }
}

