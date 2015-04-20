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
public class BasicArrays2 {
    public static void main(String[] args) {
        Random r = new Random();
       
        int arrayOne[] = new int[10];       

        
        for (int i = 0; i < arrayOne.length; i++)
        {
            arrayOne[i] =  1 + r.nextInt(100) ;
        
            System.out.println("Slot " + i + " contains a " + arrayOne[i]);
        }

    }
}
