/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class HowOldAreYou2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String name = "";
        int age = 0;
        
        System.out.println("Hey, what was your name again? ");
        name = sc.nextLine();
        
        System.out.println("Ok," + name + " How old are you? ");
        age = sc.nextInt();
        
        if (age < 16 ){
            System.out.println("You can't drive. " + name + ".");
        } else if (age <= 16 || age <= 17 ){  
            System.out.println("You can drive, but not vote. " + name + ".");
        } else if (age <= 18 || age <= 24) {
            System.out.println("You can vote, but not rent a car " + name + ".");
        } else if (age >= 25){
            System.out.println("You can pretty much do anything " + name + ".");
        }
    }
}
