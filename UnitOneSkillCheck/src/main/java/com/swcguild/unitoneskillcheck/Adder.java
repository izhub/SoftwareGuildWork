/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Adder {
    public static void main(String[] args) {
        
        int one = 0;
        int two = 0;
         
        
        System.out.println("Sums: ");
        System.out.println(add(1,1));
        System.out.println(add(2,3));
        System.out.println(add(5,8));
        System.out.println(add(95,42));
   
        
        
    }
        
    
    public static int add(int a, int b) { 
        return a + b;
    }
    
}
