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
public class CopyingArrays {

    public static void main(String[] args) {

        int[] array = new int[10];
        int[] array2 = new int[10];

        Random ran = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + ran.nextInt(99);

            array2[i] = array[i];
            array[9] = -7;
            
            System.out.print(array[i]+" ");
            

        }
        System.out.println();
        
        for (int i=0; i<array.length; i++){
            System.out.print(array2[i]+" ");
            
        }System.out.println();

    }
}
