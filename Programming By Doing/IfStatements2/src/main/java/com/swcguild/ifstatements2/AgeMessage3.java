/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ifstatements2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AgeMessage3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int age = 0; 
        String name = "";
        
        System.out.println("Enter your name: ");
        name = sc.nextLine();
        
        System.out.println("Enter your age for a message: ");
        age = sc.nextInt();
        
        if (age < 16) 
        {System.out.println(name + " you're age is " + age + " You can't drive! ");}
        if (age >= 16 && age < 18) 
        {System.out.println(name + " you're age is " + age + " You can drive but not vote");}
        if (age >= 18 && age <= 24) 
        {System.out.println(name + " you're age is " + age + " You can vote but not rent a car");}
        if (age >= 25) 
        System.out.println(name + " you're age is " + age + " You can pretty much do anything");
    }
}
