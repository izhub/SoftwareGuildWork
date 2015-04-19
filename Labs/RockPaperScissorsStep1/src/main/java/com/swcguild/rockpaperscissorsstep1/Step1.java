/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.rockpaperscissorsstep1;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Step1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int userPick = 0;
        int pcPick = 0;
        String strGame = "";

        do {
            System.out.println("Would you like to play a game? " + "Y or N");
            strGame = sc.next();
        } while (!strGame.equalsIgnoreCase("y"));

        System.out.println("Make your selection: \n 1. Rock \n 2. Paper \n 3. Scissor");
        userPick = sc.nextInt();
        pcPick = 1 + r.nextInt(3);

        if (userPick == pcPick) {
            System.out.println("It's a tie.");
        } else if (userPick == 1 && pcPick == 2) {
            System.out.println("Computer win!.");
        } else if (userPick == 1 && pcPick == 3) {
            System.out.println("You wins. ");
        } else if (userPick == 2 && pcPick == 1) {
            System.out.println("You win!");
        } else if (userPick == 2 && pcPick == 3) {
            System.out.println("Computer wins.");
        } else if (userPick == 3 && pcPick == 1) {
            System.out.println("Computer wins.");
        } else if (userPick == 3 && pcPick == 2) {
            System.out.println("You win!");
        }

    }
}
