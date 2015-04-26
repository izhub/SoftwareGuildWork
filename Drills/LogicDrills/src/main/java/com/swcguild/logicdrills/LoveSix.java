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
The number 6 is a truly great number. Given two int values, a and b, 
return true if either one is 6. Or if their sum or difference is 6.

LoveSix(6, 4) → true
LoveSix(4, 5) → false
LoveSix(1, 5) → true

*/
public class LoveSix {
    public boolean LoveSix(int a, int b) {
        int sum = a + b;
        int diff = a - b;
        
        if (a == 6 || b == 6 || sum == 6 || diff == 6){
            return true;
        } else {
            return false;
        }
    }
}
