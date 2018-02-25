/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.nestedclasses;

/**
 *
 * @author apprentice
 */
public class NestingLoops {
    public static void main(String[] args) {
        
        for (char c='A' ; c <= 'E'; c++){
            for (int n=1; n <= 3; n++) {
                System.out.println(c + " " + n);
            }
        }
        System.out.println("/n");
        
        for (int a=1; a<=3; a++) {
            for (int b=1; b <=3; b++){
                System.out.println(a + "-" + b + " ");
            
            }
        }
    }
}
