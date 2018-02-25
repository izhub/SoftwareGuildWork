/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.bmi;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMI {
    public static void main (String[] args) {
        
        double weight = 0;
        double height = 0;
        
        String stringweight ="";
        String stringheight = "";
        
        Scanner sc = new Scanner (System.in);
        
        System.out.println("Please input weight: ");
        stringweight = sc.nextLine();
        
        System.out.println("Please input height inches: ");
        stringheight = sc.nextLine();
        
        weight = Double.parseDouble(stringweight);
        height = Double.parseDouble(stringheight);
        
         double bmi = 0;
        
        bmi = (weight / (height * height)) * 703;
        
        System.out.println ("Your BMI is: " + bmi);
        
        
        
        
        
        
        
        
        
        
    }
}
