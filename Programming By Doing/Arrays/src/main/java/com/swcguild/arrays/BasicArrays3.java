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
public class BasicArrays3 {

    public static void main(String[] args) {
        Random ran = new Random();

        int[] array = new int[500];

        for (int i = 0; i < array.length; i++) {
            
           array[i] = 10 + ran.nextInt(89);
           
           if (i % 30 == 0)
                System.out.println("");
            System.out.print(array[i] + " ");

        }System.out.println("");
    }
}
