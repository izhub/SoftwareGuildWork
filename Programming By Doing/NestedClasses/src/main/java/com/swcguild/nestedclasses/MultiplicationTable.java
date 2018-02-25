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
public class MultiplicationTable {
    public static void main(String[] args) {
        
        System.out.print("x |");
        
        for(int t=1; t<10; t++){
            System.out.print("\t"+t);
        }
        
        System.out.println("");
        System.out.print("==+============================================================================");
          
        for (int x=1; x<=20; x++){
      
            System.out.print("\n"+x+ " |\t");
            for(int n=1; n<=9; n++){
     
                System.out.print(n*x+"\t");
            } 
            
        }System.out.println(" ");
    }
    
}
