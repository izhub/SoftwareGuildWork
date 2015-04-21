/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WhatIsYourNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = 0;
        
        System.out.println("Enter a number: ");
        num = sc.nextInt();
        
        System.out.println("number was: " + num);
        
        for (int i =0; i <= num; i++) {
            System.out.println(i);
        }
            System.out.println("Thank you for playing. ");
    }
}
