/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmups;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Age {
    
    public static void main ( String[] args) {
        
        int age = 0;
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("Please enter your age: ");
        age = keyboard.nextInt();
        
        if (age <= 18) {
            System.out.println("You must be in School");
        } else if (age > 18 && age < 65) {
            System.out.println("Time to go to work");
        } else {
            System.out.println("Enjoy your retirement! :)");
                    
                   
                    }
        }
    }
    
