/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrays;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class MultiDimensionalArray {
      public static void main(String[] args) {
        
        int[][] array = new int[10][10];
        Random ran = new Random();
        
        for (int row=0; row< array.length; row++){
            for(int col=0; col<array[row].length;col++){
                array[row][col] = ran.nextInt(100);
                System.out.print(array[row][col] + "\t");
            }System.out.println("\n");
        }
        
       
    }
      
      
}
