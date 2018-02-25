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
        System.out.println("true and true = " + howTrue(true,true));
        System.out.println("false and false = " + howTrue(false,false));
        System.out.println("true and false = " + howTrue(true, false));
        System.out.println("false and true = " + howTrue(false,true));
        
    }   
    

    public static String howTrue(boolean a, boolean b){
        if (a && b ) return "BOTH";
        else if (!a && !b ) return "NEITHER";
        else return "ONLY ONE";
 }
}
