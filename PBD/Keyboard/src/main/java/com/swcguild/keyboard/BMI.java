/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.keyboard;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMI {
    
    public static void main (String[] args) {
        
        int weight = 0;
        int feet = 0;
        int inches = 0;
        double height = 0;
        double meter = 0;
        double kilos = 0;
        double bmi1 = 0;
        double bmi2 = 0;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your weight in pounds: ");
        weight = sc.nextInt();
        
        System.out.print("Enter your height (feet only): ");
        feet = sc.nextInt();
        
        System.out.print("Enter your height in inches: ");
        inches = sc.nextInt();
        
        System.out.print("Enter your height in meters: ");
        meter = sc.nextDouble();
        
        System.out.print("Enter your weight in kg: ");
        kilos = sc.nextDouble();
        
        height = ((feet * 12) + inches);
        bmi1 = (weight / (height * height)) * 703;
        bmi2 = (kilos / (meter * meter));
        
        System.out.println("Your BMI is " + bmi1 +" in imperical " + bmi2 + " in metric");
        
        
        
    }
    
}
