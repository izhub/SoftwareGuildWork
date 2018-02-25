/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.warmups;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class PrimeFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("(Enter number: ");
        int num = sc.nextInt();

        for (int i = 2; i <= num; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i + " is prime.");
            }
        }

    }
}
