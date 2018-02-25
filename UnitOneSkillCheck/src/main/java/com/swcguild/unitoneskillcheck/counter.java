/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class counter {
    public static void main(String[] args) {
        
        toTen();
        System.out.println();
        toN(3); 
        System.out.println();
        toN(8);  
        System.out.println();
        toN(200);
    }
   public static void toTen() {
       for (int i=1; i <= 10; i++)
           System.out.println(i);
   }
   public static void toN(int n) {
       for (int i = 0; i <= n; i++)
           System.out.println(i);
   } 
}
