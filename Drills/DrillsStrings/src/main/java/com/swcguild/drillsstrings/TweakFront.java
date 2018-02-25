/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsstrings;

/**
 *
 * @author apprentice
 */
public class TweakFront {
    
//  Given a string, return a version without the first 2 chars. Except keep the 
//  first char if it is 'a' and keep the second char if it is 'b'. 
//  The string may be any length.
//
//TweakFront("Hello") -> "llo"
//TweakFront("away") -> "aay"
//TweakFront("abed") -> "abed"

public String TweakFront(String str) {
    
    StringBuilder sb = new StringBuilder();
    sb.append(str);
    
    int num = 0;
    
    if (!Character.toString(sb.charAt(0)).equals("a")){    
        sb.deleteCharAt(0);  
        num =- 1;
        }
    
    
    if (!(Character.toString(sb.charAt(1+num))).equals("b")){
        sb.deleteCharAt(1 +num);
    }
    return sb.toString();    

}
}
