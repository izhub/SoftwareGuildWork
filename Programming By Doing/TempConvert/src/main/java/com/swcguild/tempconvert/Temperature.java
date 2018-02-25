/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.tempconvert;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Temperature {
    public static void main (String[] args) {
        
        float fahren, cel;
        
        String strfahren = "";
        
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter Temperature in Fahrenheit: ");
        fahren = Float.parseFloat(sc.nextLine());
        
        cel = (((fahren - 32) * 5)/9);
        
        System.out.println(fahren + " in Celsius is " + cel);
        
        
        
        
    }
}
