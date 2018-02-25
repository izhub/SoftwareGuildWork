/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.studentquizgrade;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class StudentIO {
    
    Scanner sc = new Scanner(System.in);
    
    String prompt = "";
    int intA = 0;
    float floatA = 0;
    double doubleA = 0;
    
    public int getInt(String prompt) {
        System.out.println(prompt);
        intA = sc.nextInt();
        return intA;
    }
    public int intMaxMin(String prompt, int max, int min){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            intA = sc.nextInt();
        } while ( intA >= min &  intA<= max);
        return intA;       
               
    }
    public String getString( String prompt) {
        System.out.println(prompt);
        prompt = sc.next();
        return prompt;
        
    }
    public float getFloat(String prompt){
        System.out.println(prompt);
        floatA = sc.nextFloat();
        return floatA;
    }
    public float getFloatMinMax( String prompt, float min, float max){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            floatA = sc.nextInt();
        } while ( floatA >= min &  floatA<= max);
        return floatA; 
    }
    public double getDouble( String prompt){
        System.out.println(prompt);
        doubleA = sc.nextDouble();
        return doubleA;
    }
    public double getDoubleMinMax(String prompt, double min, double max){
        
        do {
            System.out.println(prompt + min  + prompt + max);
            doubleA = sc.nextInt();
        } while ( doubleA >= min &  doubleA<= max);
        return doubleA; 
    }
    public void String(String prompt){
        System.out.println(prompt);
    }
}
