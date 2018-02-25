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
public class FindDuplicates {

    public static void main(String[] args) {
        
        Random r = new Random();
        
        int[] array = new int[10];
        
        for(int i=0; i < array.length; i++){
            array[i] = 1 + r.nextInt(100);
            System.out.print(array[i] + " ");
            
            for (int j=0; j < array.length; j++){
                
                if (array[i] == array[j] && i != j){
                    System.out.println("Duplicates: " + array[i]);
                }
            }
        }
        System.out.println("");
    }
}    
// Other ways : http://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html
