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
        toN(3);             // try to reconcile the error if time permits
        toN(8);             // thinking of how to make non-static code work in static method
        toN(200);
    }
   public static void toTen() {
       for (int i=1; i <= 10; i++)
           System.out.println(i);
   }
   public void toN(int a) {
       for (int i = 0; i <= a; i++)
           System.out.println(i);
   } 
}
