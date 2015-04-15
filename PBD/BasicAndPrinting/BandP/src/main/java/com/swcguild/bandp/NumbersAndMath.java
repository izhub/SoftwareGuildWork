/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bandp;

/**
 *
 * @author apprentice
 */
public class NumbersAndMath {
    
    public static void main (String[] args) {
        
        System.out.println("I will now count my chickens: ");
        // divide 30 by 6 and add 25
        System.out.println("Hen: " + (25 + 30 / 6));
        //multiply 25 with 3.4 and subtract 100
        System.out.println("Rooster: " + (100 - 25 * 3 % 4));
        
        System.out.println("Now I will count the eggs: ");
        // use PEMDAS to calculate properly
        System.out.println(3 + 2 + 1 - 5 + 4 % 2 - 1 / 4 + 6);
        
        System.out.println("Is it true that 3 + 2 < 5 - 7 ?" );
        // is 3 plus 2 less than 5 minus 7
        System.out.println(3 + 2 < 5 - 7);
        // add 3 and two
        System.out.println("What is 3 + 2? " + (3 + 2));
        // subtract 5 and 7
        System.out.println("What is 5 - 7? " + (5 - 7));
        
        System.out.println("Oh, what is why it's false!");
        
        System.out.println("How about some more.");
        // is 5 greater than -2
        System.out.println("Is it greater? " + (5 > -2));
        // is 5 greater than or equal to -2
        System.out.println("Is it greater or equal? " + (5 >= -2));
        // is 5 leass than or equal to -2
        System.out.println("Is it less than or equal? " + (5 <= -2));
    }
    
}
