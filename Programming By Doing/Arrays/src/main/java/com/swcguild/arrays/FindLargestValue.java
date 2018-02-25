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
public class FindLargestValue {
    public static void main(String[] args) {
        Random r = new Random();
        int max = Integer.MIN_VALUE;
        int[] array = new int[10];
        
        for(int i=0; i< array.length; i++){
            array[i] = 1 + r.nextInt(100);
        
            if (array[i] > max){
            max = array[i];
        }
            System.out.println(array[i]);
        }System.out.println("");
            System.out.println("The Largest value is " +max );
    }
}
