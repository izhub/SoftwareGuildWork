/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsarrays;

/**
 *
 * @author apprentice
 */
public class Make2 {
    /*
     Given 2 int arrays, a and b, return a new array length 2 containing, as 
     much as will fit, the elements from a followed by the elements from b. 
     The arrays may be any length, including 0, but there will be 2 or more 
     elements available between the 2 arrays. 

     Make2({4, 5}, {1, 2, 3}) -> {4, 5}
     Make2({4}, {1, 2, 3}) -> {4, 1}
     Make2({}, {1, 2}) -> {1, 2}
     */

    public int[] make2(int[] a, int[] b) {

        int i = 0;
        int j = 0;
        int array[] = new int[2];

        while (i < a.length && i < 2) {  // or && i< array.lenght
            array[i] = a[i];
            i++;
        }
        while (j < b.length && i < 2) {
            array[i] = b[j];
            i++;
            j++;

        }
        return array;
    }
}
