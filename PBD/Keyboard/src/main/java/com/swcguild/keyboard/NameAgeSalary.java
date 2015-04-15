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
public class NameAgeSalary {
    
    public static void main (String[] args) {
        
        String name = "";
        int age = 0;
        float salary = 0;
        
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print ("Hello, What is your name? ");
        name = keyboard.next();
        
        System.out.print("Hi " + name + "!, How old are you? ");
        age  = keyboard.nextInt();
        
        System.out.print("So you're "+ age + ", eh? that's not that old at all! how much do you make "
                + name +"? ");
        salary = keyboard.nextFloat();
        
        System.out.println(salary+"! I hope that's per hour and not yearly! LOL!");
       
        
    }
    
}
