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
Given a number n, return true if n is in the range 1..10, inclusive. 
Unless "outsideMode" is true, in which case return true if the number is 
less or equal to 1, or greater or equal to 10. 

InRange(5, false) → true
InRange(11, false) → false
InRange(11, true) → true
n = 1-10
outsideMode = n <= 1 || >=10
*/
public class InRange {
    public boolean InRange (int n, boolean outsideMode){
        
        if (outsideMode){
            if (n <= 1 || n >= 10) {
                return true;
            } else {
                return false;
            }
        } else {
            if (n >= 1 && n <= 10 ){
                return true;
            } else {
                return false;
            }
        }
    }
}
