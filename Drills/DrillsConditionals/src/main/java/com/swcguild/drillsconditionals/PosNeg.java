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
 Given two int values, return true if one is negative and one is positive. 
 Except if the parameter "negative" is true, then return true only if both are negative. 

 PosNeg(1, -1, false) -> true
 PosNeg(-1, 1, false) -> true
 PosNeg(-4, -5, true) -> true
 */
/*

 */
public class PosNeg {

    public boolean posNeg(int a, int b, boolean negative) {

        if ((negative) && (a < 0 && b < 0)) {
            return true;
        } else if (a < 0 && b < 0) {
            return false;
        } else if (a < 0 || b < 0){
            return true;
        } else {
            return false;
        }
    }
}
