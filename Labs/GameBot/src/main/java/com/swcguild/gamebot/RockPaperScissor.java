/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.gamebot;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
/*
 Lab: Refactor RPS
 Refactor your final version of Rock, Paper, Scissors to use methods for better code
 organization. Follow the process below:

 Plan your methods (check in with instructor after all methods have been planned):
 ○ How many?
 ○ Where will they be used?
 ○ Return types?
 ○ Parameters?
 ○ Names?
 Flowchart each method (check in with instructor after all methods have been
 flowcharted):
 ○ What is the internal logic?
 ○ What are the error conditions?
 Implement and test (check in with instructor after all methods have been implemented
 and tested)
 */
public class RockPaperScissor {

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

                System.out.println(CheckWinner(userPick, pcPick));

                if (CheckWinner(userPick, pcPick).equalsIgnoreCase("Computer win!")) {
                    pcWin++;
                } else if (CheckWinner(userPick, pcPick).equalsIgnoreCase("It's a tie.")) {
                    ties++;
                } else {
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

    public static String CheckWinner(int player, int computer) {
        if (player == computer) {
            return "It's a tie.";

        } else if (player == 1 && computer == 2) {
            return "Computer win!";

        } else if (player == 1 && computer == 3) {
            return "You win! ";

        } else if (player == 2 && computer == 1) {
            return ("You win!");

        } else if (player == 2 && computer == 3) {
            return ("Computer wins!");

        } else if (player == 3 && computer == 1) {
            return ("Computer wins!");

        } else {
            return ("You win!");

        }
    }

}
