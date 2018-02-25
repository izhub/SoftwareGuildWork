/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.whileloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class EnterPIN {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int pin = 12345;
        
        System.out.println("Welcome to the Bank of Mitchell");
        System.out.println("Enter your P.I.N");
        int entry = keyboard.nextInt();
        
        while ( entry != pin ) {
            
            System.out.println("\n INCORRECT PIN, TRY AGAIN. ");
            System.out.println("ENTER YOUR PIN: ");
            entry = keyboard.nextInt();
        }
            System.out.println("\nENTRY ACCEPTED. YOU NOW HAVE ACCESS TO YOUR ACCOUNT");
    }
    
}
