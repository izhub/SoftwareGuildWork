/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.logicdrills;

/**
 *
 * @author apprentice
 */
/*
Return true if the given non-negative number is 1 or 2 more than a multiple of 20. 
See also: Introduction to Mod 

Mod20(20) → false
Mod20(21) → true
Mod20(22) → true

*/
public class Mod20 {
    public boolean Mod2(int n){
        
        if (n % 20 == 0 + 2 || n % 20 ==0 + 1){
            return true;
        } else {
            return false;
        }
    }
}
