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
public class LocateLargestValue {

    public static void main(String[] args) {

        Random r = new Random();

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            list.add(1 + r.nextInt(100));
        }
            System.out.println("Array List: " + list);
            int max = Collections.max(list);
            int slot = 1+  list.indexOf(max);

            System.out.println("Largest number is " + max);
            System.out.println("Located in slot " + slot);
        
    }
}
//Write a program that creates an ArrayList of Integers. Fill the ArrayList with 
//random numbers from 1 to 100. Display the values in the ArrayList on the screen. 
//Then use a linear search to find the largest value in the ArrayList, and display 
//that value and its slot number.
