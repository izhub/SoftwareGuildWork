/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arraylists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author apprentice
 */
public class LargestValue {

    public static void main(String[] args) {

        Random r = new Random();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int num = 1 + r.nextInt(100);
            list.add(num);
            
        }
        System.out.println("Array List: "+list);
        int max= Collections.max(list);
                 
        System.out.println("Largest value is "+ max);
    }

}
//Write a program that creates an ArrayList which can hold Integers. 
//Fill the ArrayList with random numbers from 1 to 100. 
//Display the values in the ArrayList on the screen. Then use a linear search to 
//find the largest value in the ArrayList, and display that value.
//
//ArrayList: [45, 87, 39, 32, 93, 86, 12, 44, 75, 50]
//
//The largest value is 93
