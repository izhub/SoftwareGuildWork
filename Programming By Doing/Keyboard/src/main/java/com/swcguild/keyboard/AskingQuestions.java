/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.keyboard;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AskingQuestions {
    
    public static void main (String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        
        int age;
        String height;
        String height2;
        double weight;
        
        System.out.print ("How old are you? ");
        age = keyboard.nextInt();
        
        System.out.print ("How many feet tall are you? ");
        height = keyboard.next();
        
        System.out.print("How many inches? ");
        height2 = keyboard.next();
        
        System.out.print ("How much do you weight? ");
        weight = keyboard.nextDouble();
        
        System.out.println("So you're " +  age + " old," + height + "'" + height2 + " tall," 
                + weight + " heavy.");
       
        
    }
    
}
