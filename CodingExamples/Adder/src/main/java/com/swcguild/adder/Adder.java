/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.adder;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Adder {
    
    public static void main (String[] args) {
        int op1 = 0;
        int op2 = 0;
        int sum = 0;
       
        Scanner sc= new Scanner(System.in);
        
        String stringop1 ="";
        String stringop2 ="";
        
        System.out.println("Please enter the first number to be added: ");
        stringop1 = sc.nextLine();
        
        System.out.println("Please enter the second number to be added: ");
        stringop2 = sc.nextLine();
        
        op1 = Integer.parseInt(stringop1);
        op2 = Integer.parseInt(stringop2);
        
        sum = op1 + op2;
        
                
        
        System.out.println(sum);
        
    
    }
    
}
