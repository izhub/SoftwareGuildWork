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
public class MultipleEndings {
/*
 Given a string, return a new string made of 3 copies of the last 2 chars of 
    the original string. The string length will be at least 2. 

MultipleEndings("Hello") -> "lololo"
MultipleEndings("ab") -> "ababab"
MultipleEndings("Hi") -> "HiHiHi"
 */    
    public String MultipleEndings(String str) {
        String newString = "";
        
        if (str.length() >= 2){
            for (int i = 0; i < 3; i++) {
                newString += str.substring(str.length() -2);
            }
        }
        return newString;

}
}
