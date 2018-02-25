/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.methodexamples;

/**
 *
 * @author apprentice
 */
public class MethodExamples {
    public static void main(String[] args) {
        printHiYa();
        System.out.println(calculatePi());  // methods are expression and can be used as such
        System.out.println(add(2,4));
        
        int num1 = 5;
        int num2 = 3;
        int sum =  add(num1, num2);
        System.out.println(sum);
    }
    public static void printHiYa() {
        System.out.println("HiYa"); // since 'void', 'return' not required
    }
    public static double calculatePi() {
        return 3.1419;  // must have a return and a value of "double" type 
    }
    public static int add1And1() {
        return 1 + 1; 
    }
    public static int add1And2() {
        return 1 + 2;
    }
    
    public static int add(int a, int b) {  // input parameter means you have bunch of variables, requires name and type
        
        return a + b;
    }
 }
