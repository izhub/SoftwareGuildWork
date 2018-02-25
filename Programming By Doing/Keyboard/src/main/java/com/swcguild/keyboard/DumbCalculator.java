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
public class DumbCalculator {
    
    public static void main (String[] args){
        
        float num1 = 0;
        float num2 = 0;
        float num3 = 0;
        float result = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("What is your first number: ");
        num1 = keyboard.nextFloat();
        
        System.out.print("What is your second number: ");
        num2 = keyboard.nextFloat();
        
        System.out.print("What is your third number: ");
        num3 = keyboard.nextFloat();
        
        System.out.println("("+num1 + " + " + num2 +" + " +num3+")/ 2 is " +(num1+num2+num3)/2);
    }
    
}
