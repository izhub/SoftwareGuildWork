/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.drillsconditionals;

/**
 *
 * @author apprentice
 */
/*
The parameter weekday is true if it is a weekday, and the parameter vacation is 
true if we are on vacation. We sleep in if it is not a weekday or we're on vacation. 
Return true if we sleep in. 

sleepIn(false, false) -> true
sleepIn(true, false) -> false
sleepIn(false, true) -> true

*/
public class SleepingIn {
    
    public boolean SleepingIn(boolean weekday, boolean vacation){
        
        if (!weekday || vacation){
            return true;
        } else {
            return false;
        }
    }
}
