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
public class LittleQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String q = "";
        int q1 = 0;
        int q2 = 0;
        int q3 = 0;
        
        int count = 0;
        
        System.out.println("Are you ready for a Quiz?");
        q = sc.next();
        
        System.out.println("Ok, here it comes!");
        
        System.out.println("What is the capital of Alska? "
                + "1. Mebourne 2. Anchorage 3. Juneau");
        q1 = sc.nextInt();
        
        if (q1 == 3){
            System.out.println("Correct!");  
            count = count + 1;
        } else System.out.println("Wrong");
                           
        System.out.println("Q2. Can you store the value 'cat' in a variable of type int "
                + "1. Yes 2. No");
        q2 = sc.nextInt();
        
        if (q2 == 2){
            System.out.println("Correct!");
            count = count + 1;
        } else System.out.println("Sorry, cat is a string. ints can only store number");
        
        System.out.println("What is the result of 9+6/3? "
                + "1. 5 2. 11 3. 15/3");
        q3 = sc.nextInt();
        
        if (q3 == 2){
            System.out.println("Correct!");
            count = count + 1;
        } else System.out.println("wrong");
                
        System.out.println("Overall, you got " + count + " out of 3 correct.");
        System.out.println("thanks for playing!");       
    }   
    
}
