/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsloops;

/**
 *
 * @author apprentice
 */
public class Patterns51 {
    /*  
     Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, 
     followed by the value plus 5, followed by the value minus 1.

     Pattern51({1, 2, 7, 1}) -> true
     Pattern51({1, 2, 8, 1}) -> false
     Pattern51({2, 7, 1}) -> true
     */

    public boolean Pattern51(int[] numbers) {

        for (int i=0; i < numbers.length - 2; i++) {
            if (numbers[i] + 5 == numbers[i + 1]) {
                if (numbers[i] - 1 == numbers[i + 2]) {
                    return true;
                }
            } 
        }
        return false;
    }
}
