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
Given 2 ints, a and b, return their sum. However, sums in the range 10..19 
inclusive are forbidden, so in that case just return 20. 

SkipSum(3, 4) → 7
SkipSum(9, 4) → 20
SkipSum(10, 11) → 21

*/
public class SkipSum {
    
    public int SkipSum(int a, int b){
        
        int sum = a + b;
        if (sum >= 10 && sum <= 19){
            return 20;
        }else {
            return sum;
        }
    }
}
