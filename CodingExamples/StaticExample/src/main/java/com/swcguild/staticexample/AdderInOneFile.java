/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.staticexample;

/**
 *
 * @author apprentice
 */
public class AdderInOneFile {
    public static void main(String[] args) {
        
        int sum = add(3,2);
        
    }
   
    public static int add(int a, int b){        // make it static in order to call it in main
        return a + b;
    }
}
