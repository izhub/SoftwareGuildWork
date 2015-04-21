/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.unitoneskillcheck;

/**
 *
 * @author apprentice
 */
public class AreTheyTrue {
    public static void main(String[] args) {
        
        String one = "";
        String two = "";
        
        System.out.println("True or False:");
        System.out.println("true and true = " + howTrue("true","true"));
        System.out.println("false and false = " + howTrue("false","false"));
        System.out.println("true and false = " + howTrue("true","false"));
        System.out.println("false and true = " + howTrue("false","true"));
        
    }   // not sure yet of what to do here, skipped ahead to do the others and will come back to it
    
    public static void  howTrue( String a, String b){
        if ( a.equalsIgnoreCase("true") && b.equalsIgnoreCase("true")) {
            System.out.println("Both"); 
        } else  if (a.equalsIgnoreCase("true") && b.equalsIgnoreCase("false")) {
            System.out.println("ONLY ONE");
    } else   {System.out.println("NEITHER");
    }   
        
 }
}
