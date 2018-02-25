/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizor;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Factorizor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number to factor: ");
        int num = sc.nextInt();

        System.out.println("Factors of " + num + " are: ");

        int count = 0;
        int sum = 0;

        for (int i = 1; i < num; i++) {

            if (num % i == 0) {
                count++;
                sum += i;
                System.out.println(i);
            }                      

        }
        System.out.println("Total number of factors: " + count);
                      
        if (sum == num) {
            System.out.println(num + " is a perfect square.");
        } else {
            System.out.println(num + " is not a perfect square.");
        }
        
        if (count > 2) {
                System.out.println(num + " is not a prime number.");
            } else {
                System.out.println(num + " is a prime number.");
            }
        
    }
}
