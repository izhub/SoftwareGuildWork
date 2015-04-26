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
Given two int values, return their sum. However, if the two values are the same, 
then return double their sum. 

SumDouble(1, 2) -> 3
SumDouble(3, 2) -> 5
SumDouble(2, 2) -> 8

*/
public class SumDouble {
    public int SumDouble(int a, int b){
        int sum = a +b;
        if (a == b){
            return sum * 2;
        } else {
            return sum;
        }
    }
}
