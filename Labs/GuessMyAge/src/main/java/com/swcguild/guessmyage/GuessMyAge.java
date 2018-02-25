/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.guessmyage;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class GuessMyAge {
    public void play() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Guess my age: ");
        int ageGuess = sc.nextInt();
        
        if (ageGuess == 12) {
            System.out.println("you win!");
        } else {
            System.out.println("you're wrong, you loose!");
        }
    }
}
