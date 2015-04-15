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
public class AgeInFive {
    
    public static void main (String[] args){
        
        String name = "";
        int age = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("What is your name? ");
        name = keyboard.next();
        
        System.out.print("Hi, " + name + "! How old are you? ");
        age = keyboard.nextInt();
        
        System.out.println("Did you know that in five years you will be " + (age +5)+ " years old?");
        System.out.println("And five years ago you were " + (age - 5)+ "! Imagine that!");
       
        
    }
    
}
