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
public class basicNestedLoops {
    public static void main(String[] args) {
        
        for(int f=0; f<6; f++){
            for (int s=0; s<6; s++){
                System.out.print("("+f+","+s+")\t");
            }System.out.println("");
        }
    }
   
}
