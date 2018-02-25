/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.keyboard;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ForgetfulMachine {
    
    public static void main (String[] args){
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.print("Give me a word! ");
        keyboard.next();
        System.out.print("Give me another word! ");
        keyboard.next();
        System.out.print("Give me a number! ");
        keyboard.next();
        System.out.print("Give me another number! ");
        keyboard.next();
        
        System.out.println("Whew! wasn't that fun!");
        
    }
    
}
