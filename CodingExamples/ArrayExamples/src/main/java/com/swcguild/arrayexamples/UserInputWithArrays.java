/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.arrayexamples;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class UserInputWithArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int [] userInputs = new int[10];
        
        System.out.println("Please enter 10 values: ");
        
        for (int i = 0; i < userInputs.length; i++)
        {
            System.out.println("Please enter value you fool [ " + (i+1) + " ]:");
            userInputs[i] = sc.nextInt();
            
        }
        int min = userInputs[0];
        int max = userInputs[0];
        int total = 0;
        
        System.out.print("[ ");
        for (int num: userInputs) // enhanced loop where each elment of array is put into var num
        {
            if (num > max) max = num;
            if (num < min) min = num;
            total += num; 
            System.out.print(num +"");
        }
        System.out.print(" ]");
        
     // managing arrays....
        
        int[] tmpInputs = new int[userInputs.length + 10]; // grow previous container by 10
        
        // copy of content
        for (int i = 0; i < userInputs.length; i++) // deep copy
        {
            tmpInputs[i] = userInputs[i];
        }
        userInputs = tmpInputs; // known as shadow copying
        System.out.println("Min: " + min + " Max: " + max + " Avg: " + (double)total/userInputs.length);
    
    }
}
