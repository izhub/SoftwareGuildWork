/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rockpaperscissorsstep4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Step4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int userPick = 0;
        int pcPick = 0;
        String strGame = "";
        int rounds = 0;

        int ties = 0;
        int uWin = 0;
        int pcWin = 0;

        do {
            System.out.println("How many rounds would you like to play? ");
            rounds = sc.nextInt();

            if (rounds > 10 || rounds <= 0) {
                System.out.println("Error! out of range.");
                break;
            }

            for (int i = 1; i <= rounds; i++) {

                System.out.println("\n Make your selection: \n 1. Rock \n 2. Paper \n 3. Scissor \n");
                userPick = sc.nextInt();
                pcPick = 1 + r.nextInt(3);

                System.out.println("Computer choice was: " + pcPick);

                if (userPick == pcPick) {
                    System.out.println("It's a tie.");
                    ties++;
                } else if (userPick == 1 && pcPick == 2) {
                    System.out.println("Computer win!.");
                    pcWin++;
                } else if (userPick == 1 && pcPick == 3) {
                    System.out.println("You win. ");
                    uWin++;
                } else if (userPick == 2 && pcPick == 1) {
                    System.out.println("You win!");
                    uWin++;
                } else if (userPick == 2 && pcPick == 3) {
                    System.out.println("Computer wins.");
                    pcWin++;
                } else if (userPick == 3 && pcPick == 1) {
                    System.out.println("Computer wins.");
                    pcWin++;
                } else if (userPick == 3 && pcPick == 2) {
                    System.out.println("You win!");
                    uWin++;
                }

            }
            System.out.println("=============================");
            System.out.println("Number of game ties: " + ties);
            System.out.println("Number of computer wins: " + pcWin);
            System.out.println("Number of your wins: " + uWin);
            if (pcWin > uWin) {
                System.out.println("Final winnner: Computer");

            } else if (uWin > pcWin) {
                System.out.println("Final winner: You!");
            } else {
                System.out.println("Game was a tie!");
            }

            do {
                System.out.println("\n Would you like to play again: " + "Y or N");
                strGame = sc.next();
                if (strGame.equalsIgnoreCase("n"));
                {
                    System.out.println("\n Thanks for playing, have an awesome day! :D");
                }
            } while (strGame.equalsIgnoreCase("y"));

        } while (rounds > 10 || rounds <= 0);
    }
}
