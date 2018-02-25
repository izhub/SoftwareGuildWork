/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.conditionalexamples;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MenuSystemWithSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String userChoice = "";
        
        System.out.println("=================================");
        System.out.println("O: Open File");
        System.out.println("S: Save File");
        System.out.println("N: Next File");
        System.out.println("X: Exit");
        System.out.println("=================================");
        
        System.out.println("Please choose one of the above options.");
        
        userChoice = sc.nextLine();
        
        switch (userChoice.toLowerCase()) {
            case ("O"):
                System.out.println("Opening File");
                break;
            case "S":
                System.out.println("Save a File");
                break;
            case "N":
                System.out.println("Creating new File");
                break;
            case "X":
                System.out.println("Exiting File");
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
    
}
